# Car-allowance-desktop-app-Java-
login account:
    -fatima abid
    -Password:147

(1) Application user management:
 This module will be managed by the administrator only to allow him to create new users of the application. In addition, edit user information, suspend a user’s account while on leave, and delete a user. In addition, the administrator of the application is a privileged user, who can use all the services offered by the application.

(2) Customer management This module will allow you to:
 • Add a new customer with all of the information that you think is useful (client_code, full name, Address, GSM number, scanned image of his driver's license, etc.); 
 • Modify or delete an existing customer specified by name & CIN; 
 • Display the list of clients in alphabetical order; 
 • Search for a customer by their full name & CIN and display the corresponding record. 
 • Return to the main menu.

(3) Management of reservations:
 Reservations by telephone can only be made by clients of the agency and not by a new client. A new client must go to the agency to be able to make a reservation or sign a rental contract directly after being added as a client in the application. This module will allow you to:
 • Add a new reservation with all its information that you think is useful (reservation_code, reservation date, departure date, return date, etc.);
 • Modify or delete an existing reservation;
 • Display the list of reservations in descending order of the reservation date;
 • Display the list of validated reservations;
 • Display the list of non-validated reservations;
 • Display the list of canceled reservations;
 • Search for a reservation by its code and display the corresponding record;
 • Return to the main menu.

(4) Gestion des contrats de location: 
A reservation validated before 2 days from the vehicle rental date will give rise to a new contract. 
The customer must return the vehicle he has rented on the day the rental contract expires. Each day of delay is punished by a fine of 2000 DH(almost 200$). This module will allow you to: • Add a new contract with all its information that you think is useful (Contract number; contract_date; expiry date; etc.); 
 • Modify or delete a contract specified by contract code;
 • Display the list of contracts in descending order of the contract date;
 • Search for a contract by its code and display the corresponding record;
 • Return to the main menu.

(5) Management of invoices :
An invoice concerns a single contract and will be delivered to the customer after editing and signature of the contract by the latter. This module will allow you to: 
 • Add a new invoice with all its information that you think is useful (Invoice number; invoice date; amount paid, etc.);
 • Modify or delete an existing invoice; 
 • Display the list of invoices in descending order of the invoice date; 
 • Search for an invoice by code and display the corresponding record; 
 • Return to the main menu.

(6) Vehicle management This module will allow you to: 
 • Add a new vehicle with all its information that you think is useful (Registration number, brand, type, fuel, KM counter, date of entry into service, etc.); 
 • Modify or delete an existing vehicle; 
 • Display the list of vehicles; 
 • Search for a vehicle by its registration code and display the corresponding registration; 
 • Return to the main menu.

(7) Parking management This module will allow you to:
 • Add a new car park with all the information that you think is useful (car park number; capacity; street; district, etc.);
 • Modify or delete an existing car park; • Return or deposit a vehicle in a car park;
 • Get a vehicle out of a parking lot; • Display the list of vehicles per car park and the number of empty spaces per car park;
 • Search for a car park by name and display the corresponding registration;
 • Return to the main menu.

(8) Sanctions management This module will allow you to:
  Adjust the sanctions for customers who have delayed the return of vehicles; 
  Display the list of sanctioned customers; 
  Return to the main menu.

Some management rules:
 - A customer can make one or more reservations by telephone call. These reservations after validation are the subject of contracts signed by the client.
 - A contract or reservation concerns only one customer and one vehicle.
 - A reservation that has not been paid before 2 days from the rental date of the vehicle will be canceled.
 - A reservation which has been paid before 2 days will give rise to a contract. 
 - A customer can have one or more invoices. 
 - An invoice concerns only one customer and one contract.
 - A customer can rent one or more cars which already exist in the car park. 
 - A vehicle can only be rented by one customer and can be rented after its return to another customer.
 - A vehicle can exist in a single parking lot if it is returned. 
 - A parking lot can contain several vehicles. 
 - The number of vehicles parked in a car park must not exceed the capacity of the latter.
