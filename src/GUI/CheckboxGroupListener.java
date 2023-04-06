package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CheckboxGroupListener implements ActionListener {
    private JCheckBox[] checkboxes;
    private int maxChecked;

    public CheckboxGroupListener(JCheckBox[] checkbox, int maxChecked) {
        this.maxChecked = maxChecked;
        this.checkboxes = checkbox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int checkedCount = 0;
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkedCount++;
            }
        }
        if (checkedCount > maxChecked) {
            ((JCheckBox) e.getSource()).setSelected(false);
        }
    }
}
