# clothes-and-footwear-warehouse
Fundamentals of Programming - Course Project

<h3>System Architecture Design</h3>

This project is a Java-based application for the clothes and foot warehouse business and is divided into different layers to ensure the modularity and architecture of an application. The project is comprised of 5 layers which are defined below:
<ol>
  <li>View Layer</li>
  <li>Controller Layer</li>
  <li>Service Layer</li>
  <li>Dal Layer</li>
  <li>Bean Layer</li>
</ol>

<h3>1. View Layer</h3>
The view is responsible for user interaction (inputting data and displaying information). The interaction between layers in the application is strictly regulated. A layer can only communicate (transmit and receive data) with the layers located directly above or below it in the architecture.<br/>

<img width="589" alt="Screenshot 2024-04-08 at 2 29 06 AM" src="https://github.com/Khaydarov26/clothes-and-footwear-warehouse/assets/82873670/74c43762-f281-469d-892d-e0a52dae301f">

<h3>2. Controller Layer</h3>
The controller decides whether the application can execute the received request, whether the person who sent the request is allowed to take such actions, and who exactly will perform this request.
<img width="587" alt="Screenshot 2024-04-08 at 2 29 26 AM" src="https://github.com/Khaydarov26/clothes-and-footwear-warehouse/assets/82873670/7d3862c5-84b3-4c28-9cb3-e5afaf4fc731">

<h3>3. Service Layer</h3>
A Service Layer defines an application's boundary and its set of available operations from the perspective of interfacing client layers. It encapsulates the application's business logic, controlling transactions and coor-dinating responses in the implementation of its operations.
<img width="601" alt="Screenshot 2024-04-08 at 2 33 06 AM" src="https://github.com/Khaydarov26/clothes-and-footwear-warehouse/assets/82873670/38465103-465c-4546-8f88-bff5c458d2d7">

<h3>4. Dal Layer</h3>
The so-called data access layer (DAL) hides from the service layer the features and specifics of working with the data source. If a service needs to receive or store data, it asks the DAL.

This approach reduces the dependence of other modules (layers) of the application on the data source. Thus, by changing the data source or the logic for working with it (the DAL), you can leave the service layer unchanged.
Often, the data access object (DAO) design pattern is used to implement the DAL.

The DAO pattern separates the data access logic from the general logic (business logic) of an application, allowing them to be developed independently. In this pattern, data is accessed through a separate object called a DAO, which hides the details of the data storage mechanism, such as a database or file system, and provides a simple interface that allows the application to interact with the data.
<img width="589" alt="Screenshot 2024-04-08 at 2 40 49 AM" src="https://github.com/Khaydarov26/clothes-and-footwear-warehouse/assets/82873670/4402a3a4-283d-4606-8756-4e1440d0fc30">

<h3>5. Bean Layer</h3>
To tell one program component what to do or to get the result of a component's work, it is conveni
ent to use special objects called beans. They make up the corresponding layer and are separate components of the application. These objects are prohibited from processing data; they can only store and transfer it. <br/>
<img width="622" alt="Screenshot 2024-04-08 at 2 43 17 AM" src="https://github.com/Khaydarov26/clothes-and-footwear-warehouse/assets/82873670/697812cf-8060-4e11-b300-23b0e76c0d82">



