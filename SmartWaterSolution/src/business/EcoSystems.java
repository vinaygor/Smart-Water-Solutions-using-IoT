/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Role.Role;
import business.Role.SystemAdminRole;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.userAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author vinay
 */
public class EcoSystems extends Organization{
    
    private static EcoSystems business;
    private ArrayList<Network> networkList;
    
    public static EcoSystems getInstance(){
        if(business== null){
            business = new EcoSystems();
        }
        return business;
    }  

    private EcoSystems() {
        super(null);
        networkList = new ArrayList<Network>();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    public boolean checkIfNetworkisUnique(String networkName) {

        for (Network n : this.networkList) {
            if (n.getName().equals(networkName)) {
                return true;

            }

        }
        return false;

    }
    
    public boolean checkIfUsernameIsUnique(String username) {

        for (UserAccount ua : this.getUserAccountDirectory().getUserAccountList()) {
            // System.out.println("EcoSystem" + ua.getUsername());
            if (ua.getUserName().equals(username)) {
                return false;
            }
            for (Network n : this.getNetworkList()) {
                for (Enterprise ent : n.getEnterpriseList().getEnterpriseList()) {
                    for (UserAccount ucc : ent.getUserAccountDirectory().getUserAccountList()) {
                        //           System.out.println("Enterprise-->" + ucc.getUsername());
                        if (ucc.getUserName().equals(username)) {
                            return false;
                        }
                        for (Organization org : ent.getOrganizationsList().getOrganizationList()) {
                            for (UserAccount accOrg : org.getUserAccountDirectory().getUserAccountList()) {
                                //                 System.out.println("Organization-->" + accOrg.getUsername());
                                if (accOrg.getUserName().equals(username)) {
                                    return false;
                                }
                            }

                        }
                    }

                }
            }

        }
        return true;
    }
    
    public void DeleteNetwork(Network n) {
        networkList.remove(n);
    }
}
