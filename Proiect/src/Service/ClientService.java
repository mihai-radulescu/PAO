package Service;

import IO.Write;
import Users.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService {

    private List<Client> clientList;
    private static ClientService instance = null;

    private ClientService(){
        clientList = new ArrayList<>();
    }

    public static ClientService getInstance() {
        if(instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    ///Clients methods
    public void addClient(Client client, boolean ok){
        clientList.add(new Client(client));
        if(ok == true) {
            Write.writeClientsCsv(client);
            Write.writeAudit("Added client");
        }
    }

    public void showClients() {
        for(Client c : clientList)
            System.out.println(c.toString());
    }

    public Client getClient(int i){
        return this.clientList.get(i);
    }

/*    private void clientSort(){
        Collections.sort(clientList);
    }*/
}
