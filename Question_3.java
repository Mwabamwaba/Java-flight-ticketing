import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question_3 extends JFrame implements ActionListener {
    private JButton[][] seats;
    private JButton clearButton;

    public Question_3(int rows, int columns) {
        setTitle("Flight Seat Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        seats = new JButton[rows][columns];
        JPanel seatPanel = new JPanel(new GridLayout(rows, columns, 10, 10));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new JButton();
                seats[i][j].setBackground(Color.WHITE);
                seats[i][j].setPreferredSize(new Dimension(20, 20));
                seats[i][j].addActionListener(this);
                seatPanel.add(seats[i][j]);
            }
       

        clearButton = new JButton("Clear All");
        clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);

        add(seatPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
            if (clickedButton.equals(clearButton)) {
                clearAllSeats();
            } else {
                toggleSeat(clickedButton);
            }
        }
    }

    private void toggleSeat(JButton seat) {
        if (seat.getBackground() == Color.WHITE) {
            seat.setBackground(Color.RED);
        } else {
            seat.setBackground(Color.WHITE);
        }
    }

    private void clearAllSeats() {
        for (JButton[] row : seats) {
            for (JButton seat : row) {
                seat.setBackground(Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Question_3(6, 9); // Specify the number of rows and columns for seats
        });
    }
}