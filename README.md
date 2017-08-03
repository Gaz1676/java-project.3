# Programming-Java-Project.3 - Gym Console Application

_For my Java Programming Project I had to design a ___Gym console application____

_This was done using __Eclipse IDE__ and run through the Eclipse's console window_

_The details of the application are set below_
***
### Application Start Up
*** 
- _On start-up the application automatically loads the gym data __(Trainers & Members)__ from an XML file_

- _The user is asked what they want to do --> __Login(l) / Register (r)___

- _The user is asked who they are --> __Trainer(m) / Member(t)___

      * Login selected: Verification of email entered is checked through the Trainers / Members List

      * If email does not exist the console prints out _“Access Denied”_  and then exits the program

      * Register selected: User asked to enter the required details for either a Trainer / Member
      
      * If email is already used _"Invalid Email"_ is displayed and user is asked enter a new one

***
#### Logged In Function of the Application 
***
##### `Trainer Menu`
  * _The __Trainer__ is allowed to:_
   
        * Add a new Member
        
        * List all Members
        
        * Search for a Member by email
        
        * Search for a Member by name
        
        * List Members with ideal body weight
        
        * List Members with a specific BMI category
        
        * Add an assessment for a Member
        
 - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        
##### `Member Menu`       
  * _The __Member__ is allowed to:_
    
        * View their profile

        * Update their profile

        * View progress by weight

        * View progress by chest measurement

        * View progress by thigh measurement

        * View progress by upper arm measurement

        * View progress by waist measurement

        * View progress by hips measurement
    ***
- _On exiting the application the gym data for the __(Trainers / Members)__ is automatically stored to an XML file_
