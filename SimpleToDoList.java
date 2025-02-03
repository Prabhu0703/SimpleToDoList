import java.awt.*;
import javax.swing.*;

public class SimpleToDoList{
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;

    public SimpleToDoList(){
        JFrame frame = new JFrame("TO-DO LIST");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setLocationRelativeTo(null);


        JPanel Panel= new JPanel();
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        taskField = new JTextField(20);
        taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        JButton addButton = new JButton("Add Task");

        Panel.add(taskField);
        Panel.add(addButton);

        listModel = new DefaultListModel<>();
        taskList= new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JButton removeButton= new JButton("Remove Task");

        addButton.addActionListener(e->{
            String task = taskField.getText();
            if(!task.isEmpty()){
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        removeButton.addActionListener(e->{
            int selectedIndex = taskList.getSelectedIndex();
        if(selectedIndex != -1){
            listModel.remove(selectedIndex);
        }   
     });
     
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(Panel, BorderLayout.NORTH);
        frame.add(removeButton, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(SimpleToDoList::new);
}
}
