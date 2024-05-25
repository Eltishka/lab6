package gui.actions;

import dataexchange.Request;
import dataexchange.Response;
import gui.ClientConnectionGUI;
import gui.GUIController;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

@AllArgsConstructor
public class ClearAction extends AbstractAction {
    private final ClientConnectionGUI client;
    private final GUIController controller = GUIController.getAccess();

    @Override
    public void actionPerformed(ActionEvent e) {

        Request request = new Request("clear", new ArrayList<>(), controller.getUserName(), true);
        this.client.sendRequest(request);
        Response response = this.client.receiveResponse();
        JOptionPane.showMessageDialog(
                null,
                GUIController.resourceBundle.getString(String.valueOf(response.getResponseCode())),
                GUIController.resourceBundle.getString("result"),
                JOptionPane.PLAIN_MESSAGE
        );

    }
}