import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudyENT {
    public static void main(String[] args) {
        new StudyENTFrame();
    }
}

class StudyENTFrame extends JFrame {
    private JTextArea noteArea;
    private JTextField reminderField;
    private JList<String> reminderList;
    private DefaultListModel<String> reminderListModel;

    public StudyENTFrame() {
        setTitle("StudyENT - Your Partner and Notes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //pink calm theme (re-usable -Andreykuro)
        Color bgColor = new Color(255, 228, 225); // Misty Rose btw
        Color buttonColor = new Color(255, 182, 193); // Light Pink btw
        getContentPane().setBackground(bgColor);

        //logo area
        JLabel logoLabel = new JLabel("StudyENT", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Serif", Font.BOLD, 24));
        logoLabel.setForeground(new Color (199, 21, 133)); // Medium Violet
        add(logoLabel, BorderLayout.NORTH);

        //note Area
        noteArea = new JTextArea();
        noteArea.setBackground(new Color(255, 239, 213)); // idk what color this is
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        JScrollPane noteScrollPane = new JScrollPane(noteArea);
        add(noteScrollPane, BorderLayout.CENTER);

        //reminder panel
        JPanel reminderPanel = new JPanel(new BorderLayout());
        reminderPanel.setBackground(bgColor);

        reminderField = new JTextField();
        reminderField.setBackground(new Color(255, 239, 213)); // i still dk what color this is
        JButton addReminderButton = new JButton("Add Reminder");
        addReminderButton.setBackground(buttonColor);
        addReminderButton.addActionListener(new AddReminderListener());

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(reminderField, BorderLayout.CENTER);
        inputPanel.add(addReminderButton, BorderLayout.EAST);
        inputPanel.setBackground(bgColor);

        reminderListModel = new DefaultListModel<>();
        reminderList = new JList<>(reminderListModel);
        reminderList.setBackground(new Color(255, 239, 213)); // the idk color
        JScrollPane reminderScrollPane = new JScrollPane(reminderList);

        reminderPanel.add(inputPanel, BorderLayout.NORTH);
        reminderPanel.add(reminderScrollPane, BorderLayout.CENTER);

        add(reminderPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class AddReminderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String reminder = reminderField.getText().trim();
            if (!reminder.isEmpty()) {
                reminderListModel.addElement(reminder);
                reminderField.setText("");
            }
        }
    }
}