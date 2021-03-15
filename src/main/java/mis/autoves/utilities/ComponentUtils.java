package mis.autoves.utilities;

import javax.swing.*;
import java.awt.*;

public class ComponentUtils
{
    public static void addFirstComponentToPanel(GridBagConstraints constraints, JComponent component, JPanel panel)
    {
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(component, constraints);
    }

    public static void addComponentToPanel(GridBagConstraints constraints, JComponent component, JPanel panel, boolean isXZero)
    {
        if (isXZero)
        {
            constraints.gridx = 0;
        }
        else
        {
            constraints.gridx++;
        }
        constraints.gridy++;
        panel.add(component, constraints);
    }

}
