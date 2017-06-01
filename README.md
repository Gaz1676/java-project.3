# programming-java-project.3

The following processing is required in this menu system:

1. On app start-up, automatically load the gym data (trainers and members) from an XML file.

2. Ask the user do they want to login(l) or register (r).

3. Ask the user if they are a member(m) or a trainer(t).

    * If the user selected to login, verify that the email entered is stored in the
    appropriate arraylist i.e. the members or trainers list. If the email doesn’t exist,
    print out “access denied” to the console and exit the program.
    
    * If the user selected to register, ask the user to enter the required details for the
    member/trainer. If a user enters an email that is already used in the system (for 
    either trainers/members), ask let them know it is an invalid email and ask them to
    enter a new one.
    
4. Once logged in, display a trainer menu for the trainer and a member menu for the member.

    a. The trainer menu should allow the trainer to:
   
        i. Add a new member
        
        ii. List all members
        
        iii. Search for a member by email
        
        iv. Search for a member by name
        
        v. List members with ideal body weight
        
        vi. List members with a specific BMI category
        
        vii. Add an assessment for a member
        
  //////////////////////////////////////////////////////////////////////
  
    b. The member menu should allow the member to:
    
        i. View their profile

        ii. Update their profile

        iii. View progress by weight

        iv. View progress by chest measurement

        v. View progress by thigh measurement

        vi. View progress by upper arm measurement

        vii. View progress by waist measurement

        viii. View progress by hips measurement
    
5. On app exit, automatically save the gym data (trainers and members) to an XML file.
