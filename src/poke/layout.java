package poke;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class layout {
    ArrayList<JLabel> labels;
    ArrayList<JComponent> fields;

    public layout(ArrayList<JLabel> labels, ArrayList<JComponent> fields) {
        this.labels = labels;
        this.fields = fields;
    }

    public JComponent render() {
        if (this.labels.size() != this.fields.size()) {
            String s = this.labels.size() + " labels supplied for " + this.fields.size() + " fields!";
            throw new IllegalArgumentException(s);
        }

        JComponent panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        hGroup.addGroup(yLabelGroup);
        GroupLayout.Group yFieldGroup = layout.createParallelGroup();
        hGroup.addGroup(yFieldGroup);
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        layout.setVerticalGroup(vGroup);

        int p = GroupLayout.PREFERRED_SIZE;

        // Add the components to the groups
        for (JLabel label : this.labels) {
            yLabelGroup.addComponent(label);
        }

        for (Component field : this.fields) {
            yFieldGroup.addComponent(field, p, p, p);
        }

        for (int ii = 0; ii < this.labels.size(); ii++) {
            vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(this.labels.get(ii)).
                addComponent(this.fields.get(ii), p, p, p));
        }

        return panel;
    
    }
}


