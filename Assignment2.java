
import java.util.Scanner;

public class Assignment2{

private static final Scanner SCANNER = new Scanner(System.in); 
    public static void main(String[] args) {



        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = " Welcome to Smart Banking";
        final String CREATE_NEW_ACCOUNT = "create new Account";
        final String DEPOSITS = "Deposits";
        final String WITHDRAWLS = "Withdrawls";
        final String TRANSFER = "Transfer";
        final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT = "Delete Account";
        
        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String[][] accounts = new String[0][3];
      
        // String[] depositIds = new String[0];
        // String[] withdrawalIds = new String[0];
        // String[] depositterName = new String [0];
        // String[] withdrawalsNmae = new String [0];

        String screen = DASHBOARD;
            
        mainLoop:     do{
        final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\t[1]. Create new Account");
                    System.out.println("\t[2]. Deposits");
                    System.out.println("\t[3]. Withdrawls");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Delete Account");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();
                System.out.println(option);
                    switch (option){
                        case 1: screen = CREATE_NEW_ACCOUNT; break;
                        case 2: screen = DEPOSITS; break;
                        case 3: screen = WITHDRAWLS ; break;
                        case 4: screen = TRANSFER ; break;
                        case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                        case 6: screen = DELETE_ACCOUNT ; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: break;
                        
                    }
                    break;

                    case CREATE_NEW_ACCOUNT:

                    
                    System.out.printf("\tAccount ID: SDB-%05d \n", (accounts.length + 1));
                    String id = "";
                    String name;
                    boolean valid;
                    double value;

                    do{
                        valid = true;
                        System.out.print("\tEnter Customer Name: ");
                        name = SCANNER.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf(ERROR_MSG, "Customer name can't be empty");
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid name");
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);

                    do{
                        valid = true;
                        System.out.print("\tEnter Deposit value: ");
                        value = SCANNER.nextDouble();
                        SCANNER.nextLine();
                        if ( value < 5000){
                            System.out.printf(ERROR_MSG, "Insufficent Amount");
                            valid = false;
                          }  //  break;
                        }while(!valid);
                              
                           // valid = true;
                            String [][] newaccounts = new String[accounts.length+1][3];

                        for (int i = 0; i < accounts.length; i++) {
                            newaccounts [i] = accounts [i];
                        }

                            newaccounts [newaccounts.length -1][0] = id;
                            newaccounts [newaccounts.length -1][1] = name;
                            newaccounts [newaccounts.length -1][2] = Double.toString(value);

                                accounts =newaccounts;
                            System.out.println();
                            System.out.printf(SUCCESS_MSG, String.format("%s%s added successfully \n", id, name));
                            System.out.print("\tDo you want to continue adding Deposit? (Y/n)");
                            if (!SCANNER.nextLine().toUpperCase().strip().equals("Y")){screen =DASHBOARD;}
                               // screen = DASHBOARD;
                            valid = false;
                              break;
                           
                        
                            


                  case DEPOSITS:

                  int index1 = 0;

                    do {
                          
                        valid = true;
                        System.out.print("\tEnter Account Number: ");  
                        id = SCANNER.nextLine().toUpperCase().strip();
                        if (id.isBlank()){
                            System.out.printf(ERROR_MSG, "ID can't be empty");
                            valid = false;
                        }else if (!id.startsWith("SDB-") || id.length() < 8){
                            System.out.printf(ERROR_MSG, "Invalid ID format");
                            valid = false;
                        }else{
                            String number = id.substring(4);
                            for (int i = 0; i < number.length(); i++) {
                                if (!Character.isDigit(number.charAt(i))){
                                    System.out.printf(ERROR_MSG, "Invalid ID format");
                                    valid = false;
                                    break;
                                }
                            }

                        //     double current = 0.0;
                            
                        //     for (int i = 0; i < accounts.length; i++) {
                        //         if (accounts[i][2].equals(Double.toString(current))){
                                    
                        //             System.out.print("\tAccount Current Balance: " + accounts[i][2]);
                        //        //System.out.printf("\tAccount Current Balance: accounts[i][2]%05d \n", (accounts.length + 1));
                               
                        //        valid = false;
                        //        break;
                        //         }
                        //     }    
                        
                        



                        // do{
                        // valid = true;
                        // System.out.print("\tEnter Deposit value: ");
                        // value = SCANNER.nextDouble();
                        // SCANNER.nextLine();
                        // if ( value < 500){
                        //     System.out.printf(ERROR_MSG, "Insufficent Amount");
                        //     valid = false;
                        //   }  //  break;
                        // }while(!valid);
                        
                        boolean exists = false;
                        // System.out.println("for loop-");
                        // System.out.println(accounts.length);
                        // System.out.print(accounts[0][0]+", "+accounts[1][0]+", "+accounts[2][0]);
          
                     loop1 :   for (int i = 0; i < accounts.length; i++) {
                          if (accounts[i][0].equals(id)) {
                            index1 = i;
                            exists = true;
                            break loop1;
                          }
                        }
                        if (!exists) {
                          valid = false;
                          System.out.printf(ERROR_MSG, "Account is not Found");
                        }
                        
                        System.out.println("\n------------>\n"+valid);

                         if (!valid) {
                         System.out.print("\n\tDo you want to try again? (Y/n)");
                            if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                             screen = DASHBOARD;
                            continue mainLoop;
                             }else{screen = DEPOSITS; continue;}
                        }

                    }
                    System.out.println();
                    System.out.println(accounts[index1][2]);
                    Double ValueOfBalance = Double.valueOf(accounts[index1][2]);
                    System.out.println(ValueOfBalance);
      
                    System.out.printf("\tCurrent Balance : %.2f \n", ValueOfBalance);
      
                    System.out.print("\tDeposit amount : ");
                    Double depositAmount = SCANNER.nextDouble();
                    SCANNER.nextLine();
      
                    if (!(depositAmount > 500)) {
                      System.out.print("\tInsufficient Amount\n");
                      break;
                    } else {
                      accounts[index1][2] = Double.toString(Double.valueOf(accounts[index1][2]) + depositAmount);
                    }
      
                    System.out.printf("\tNew Account Balance: %.2f \n", Double.valueOf(accounts[index1][2]));
      
                    System.out.printf(SUCCESS_MSG,
                        String.format("%s has been done successfully", "Deposit"));
                    System.out.print("\tDo you want to continue (Y/n)? ");
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                       // continue;
                       valid = false;


                        
                        // System.out.println();
                        // System.out.printf(SUCCESS_MSG, String.format("%s: Deposits successfully added \n", value));
                        // System.out.print("\tDo you want to continue Deposit ? (Y/n)");
                        // if (!SCANNER.nextLine().toUpperCase().strip().equals("Y"))
                        //     screen = DASHBOARD;
                        // break;
                        
                        }else{ screen = DASHBOARD; continue mainLoop;}



                    }while (!valid);
    
    




                    case WITHDRAWLS :

                    int index2 = 0;
                    
                    
                    loopWithdraw:     do {
                        valid = true;
            System.out.print("\tEnter the Account Id (Withdraw): ");
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 8) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;
              for (int i = 0; i < accounts.length; i++) {
                if (accounts[i][0].equals(id)) {
                  index2 = i;
                  exists = true;
                  break;
                }
              }
              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account does not exist");
              }
            }

            if (!valid) {
                System.out.print("\n\tDo you want to try again? (Y/n)");
                if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                  screen = DASHBOARD;
                  //continue mainLoop;
                }else{screen = WITHDRAWLS; continue;}
              }
                System.out.println();
  
                System.out.printf("\tCurrent Balance : %.2f\n", Double.valueOf(accounts[index2][2]));
  
                System.out.print("\tWithdraw amount : ");
                Double withdraw = SCANNER.nextDouble();
                SCANNER.nextLine();
  
                if (!(withdraw > 100 || (Double.valueOf(accounts[index2][2]) - withdraw) > 500)) {
                  System.out.print("Insufficient Amount");
                  break;
                } else {
                  accounts[index2][2] = (Double.toString(Double.valueOf(accounts[index2][2]) - withdraw));
                }
  
                System.out.printf("\tNew Account Balance: %.2f\n\n", Double.valueOf(accounts[index2][2]));
  
                   System.out.printf(SUCCESS_MSG,
                   String.format("%s has been done successfully\n", "Withdraw"));
                System.out.print("\tDo you want to continue (Y/n)? ");
                if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                   // continue;
                   valid = false;
                   continue;
  
                }else{ 
                  screen = DASHBOARD; 
                //  continue mainLoop;
                break loopWithdraw;
                }
      
                    }while (!valid);
    










                    case TRANSFER:

                   
                    int customer = 0;
                    Double transfer = 0.00;
                    int[] cusId = new int[2]; 
          
                    do {

                        valid = true;
                        System.out.print("\tEnter Ttansfer Account Number: ");  
                        id = SCANNER.nextLine().toUpperCase().strip();
                        if (id.isBlank()){
                            System.out.printf(ERROR_MSG, "ID can't be empty");
                            valid = false;
                        }else if (!id.startsWith("SDB-") || id.length() < 3){
                            System.out.printf(ERROR_MSG, "Invalid ID format");
                            valid = false;
                        }else{
                            String number = id.substring(2);
                            for (int i = 0; i < number.length(); i++) {
                                if (!Character.isDigit(number.charAt(i))){
                                    System.out.printf(ERROR_MSG, "Invalid ID format");
                                    valid = false;
                                    break;
                                }
                            }
                            for (int i = 0; i < accounts.length; i++) {
                                if (accounts[i].equals(id)){
                                    System.out.printf(ERROR_MSG, "Account Number already exists");
                                    valid = false;
                                    break;
                                }
                            }    
                        
                        
                            if (!valid) {
                                System.out.print("\n\tDo you want to try again? (Y/n)");
                                if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                                  screen = DASHBOARD;
                                  //continue mainLoop;
                                }else{screen = TRANSFER; continue;}
                              }
                  
                                 System.out.printf("\tAccount Name: %s\n",accounts[customer][1]);
                                 System.out.println();
                                 customer++;
                  
                        }
                    }while (!valid);


          System.out.printf("\t\nFrom Account Balance: %.2f\n",Double.valueOf(accounts[cusId[0]][2]));
          System.out.printf("\tTo Account Balance: %.2f\n\n",Double.valueOf(accounts[cusId[1]][2]));

    

           System.out.print("\tEnter Transfer amount : ");
              transfer = SCANNER.nextDouble();
              SCANNER.nextLine();

              if (!(transfer> 100 || (Double.valueOf(accounts[cusId[0]][2])-transfer) > 500)) {
                System.out.print("Insufficient Amount");
                break;
              } else {

                Double tax = 0.02 * transfer;
                System.out.println("Tax = "+ tax);

                accounts[cusId[0]][2] = 
                (Double.toString(Double.valueOf(Double.valueOf(accounts[cusId[0]][2])- transfer - tax)));

                 accounts[cusId[1]][2] = 
                (Double.toString(Double.valueOf(accounts[cusId[1]][2])+ transfer));
             
                System.out.printf("\tNew From Account Balance: %.2f\n",Double.valueOf(accounts[cusId[0]][2]));
                System.out.printf("\tNew To Account Balance: %.2f\n", Double.valueOf(accounts[cusId[1]][2]));
            
            }





                    case CHECK_ACCOUNT_BALANCE:

                  

                    do {
                        valid = true;
                        System.out.print("\tEnter Account Number: ");  
                        id = SCANNER.nextLine().toUpperCase().strip();
                        if (id.isBlank()){
                            System.out.printf(ERROR_MSG, "ID can't be empty");
                            valid = false;
                        }else if (!id.startsWith("SDB-") || id.length() < 8){
                            System.out.printf(ERROR_MSG, "Invalid ID format");
                            valid = false;
                        }else{
                            String number = id.substring(4);
                            for (int i = 0; i < number.length(); i++) {
                                if (!Character.isDigit(number.charAt(i))){
                                    System.out.printf(ERROR_MSG, "Invalid ID format");
                                    valid = false;
                                    break;
                                }
                            }
                            for (int i = 0; i < accounts.length; i++) {
                                if (accounts[i].equals(id)){
                                    System.out.printf(ERROR_MSG, "Account Number already exists");
                                    valid = false;
                                    break;
                                }
                            }    
                        }
                    }while (!valid);
    

                        case DELETE_ACCOUNT :
                    
                      
                        int index3 = 0;
                    do {
                        valid = true;

                        valid = true;
                        System.out.print("\tEnter the Account Id: ");
                        id = SCANNER.nextLine().toUpperCase().strip();
                        if (id.isBlank()) {
                          System.out.printf(ERROR_MSG, "ID can't be empty");
                          valid = false;
                        } else if (!id.startsWith("SDB-") || id.length() < 8) {
                          System.out.printf(ERROR_MSG, "Invalid ID format-1");
                          valid = false;
                        } else {
                          String number = id.substring(4);
                          for (int i = 0; i < number.length(); i++) {
                            if (!Character.isDigit(number.charAt(i))) {
                              System.out.printf(ERROR_MSG, "Invalid ID format-2");
                              valid = false;
                              break;
                            }
                          }
                          boolean exists = false;
                          for (int i = 0; i < accounts.length; i++) {
                            if (accounts[i][0].equals(id)) {
                              index3 = i;
                              exists = true;
                              break;
                            }
                          }
                          if (!exists) {
                            valid = false;
                            System.out.printf(ERROR_MSG, "Account does not exist");
                          }
                        }
                   
                        if (!valid) {
                            System.out.print("\n\tDo you want to try again? (Y/n)");
                            if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                              screen = DASHBOARD;
                              continue mainLoop;
                            }
                            System.out.println();
              
                          }

                     
                }while (!valid);

                System.out.print("\tAre you sure to delete this account (Y/n)? ");
          if (!SCANNER.nextLine().strip().toUpperCase().equals("Y"))
            valid = false;

          

          newaccounts = new String[accounts.length - 1][3];
       //   newBankDetails = new String[BankDetails.length - 1][3];

          for (int i = 0; i < accounts.length; i++) {
            if (i < index3) {
              newaccounts[i] = accounts[i];

            } else if (i == index3) {
              continue;
            } else {
              newaccounts[i - 1] = accounts[i];
              newaccounts[i - 1] = accounts[i];
            }
          }

          accounts = newaccounts;

          System.out.println();
          System.out.printf(SUCCESS_MSG,
              String.format("%s has been deleted successfully", id));

          System.out.print("\tDo you want to continue adding (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y"))
            continue;
          screen = DASHBOARD;
          break;
          
          
          
          
          
          
          
          
          
          
            }
    
    }while(true);
    
    
  }

}
        























    
