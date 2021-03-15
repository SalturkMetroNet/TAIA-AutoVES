package mis.autoves.pages;

import mis.autoves.utilities.ConfigurationReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame
{
    private JButton submitButton;
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public LoginPage()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents()
    {
        submitButton = new JButton();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(ConfigurationReader.getProperty("frameHeader"));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        usernameLabel.setFont(new Font("Tahoma", 0, 36));
        usernameLabel.setText("Username:");

        usernameTextField.setFont(new Font("Tahoma", 0, 36));
        usernameTextField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                usernameTextFieldActionPerformed(e);
            }
        });

        passwordLabel.setFont(new Font("Tahoma", 0, 36));
        passwordLabel.setText("Password:");

        passwordField.setFont(new Font("Tahome", 0, 36));
        passwordField.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                passwordFieldActionPerformed(e);
            }
        });

        submitButton.setFont(new Font("Tahoma", 0, 36));
        submitButton.setText("Login");
        submitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                submitButtonActionPerformed(e);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(usernameTextField)
                                        .addComponent(passwordField, GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 75, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(176, 176, 176)
                                .addComponent(submitButton)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(passwordLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(submitButton)
                                .addGap(38, 38, 38))
        );

        getAccessibleContext().setAccessibleDescription("");
        pack();
        setLocationRelativeTo(null);
    }

    private void usernameTextFieldActionPerformed(ActionEvent event)
    {
        //TODO usernameTextfield handling code
    }

    private void passwordFieldActionPerformed(ActionEvent event)
    {
        //TODO passwordField handling code
    }

    private void submitButtonActionPerformed(ActionEvent event)
    {
        //TODO submitButton handling code

        if (usernameTextField.getText().equals("") && passwordField.getPassword().length < 1)
        {
            JOptionPane.showMessageDialog(this, "Please enter your Username and Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (usernameTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Username can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (passwordField.getPassword().length < 1)
        {
            JOptionPane.showMessageDialog(this, "Password can't be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            dispose();

            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    new FirstPage().setVisible(true);
                }
            });
        }
    }


}
