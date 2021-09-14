# Password Manager

In this assignment you will be implementing a version of a HashMap in order to create your own password manager.

A password manager is an application designed to store and manage someone's passwords. The #1 rule of password security
is to not reuse passwords, we all know that whenever safari or chrome recommends those strong password filled with 
random letters and numbers, no one actually uses them. However with a password manager, you can use strong passwords
because you don't have to remember them. All it takes is 1 master password for the password manager, and then you 
can access all of your stored passwords. 

## HashMap
Your Password Manager will be an implementation of the Map.java interface provided in the a8 package.
 Account.java is how we will represent an entry into the Password Manager. The method descriptions in 
 Map.java explain the logic you will implement in PasswordManager.java. The key in the Map will be the 
 name of the website you are making an account for, and the value will be the password you set. Your HashMap will be 
 stored in an Account[] of size 50, and you will use  the hashing into lists method to handle collisions, 
The Hashing algorithm you will be using to determine what index to store an Account object is actually something 
built in to every object in Java: the hashcode() method. Calling hashcode on an object will return an int that is
 computed using a hashing algorithm and properties of the object. While this number is not guaranteed to be unique, 
 it is usually quite random, but keep in mind it may be larger than the size of the array. 
 This number can also be negative so be sure to take the absolute value of it. 

## Input Output

The interface for the password manager will be a command line application that uses a Scanner to read inputs. The code 
for the input output logic should all go in the main method in Main.java. The Scanner and Password Manager object are 
already created for you. Upon running your program, your password manager should print "Enter Master Password". 
Change the value of the variable MASTER_PASSWORD in PasswordManager.java to any String of your choosing.
 If the entered password does not match the password saved in the MASTER_PASSWORD variable, reprint 
 "Enter Master Password" until the correct password is entered. Once they are given access, 
 the user should be able to enter one of the following phrases: "New password", "Get password", "Delete account", 
 "Check duplicate password","Get accounts", "Generate random password", or "Exit". If something other than these 
 7 phrases are entered, print "Command not found" and wait for another command. After each case, excluding "exit", 
 they can enter another phrase. If they enter exit, they get reprompted to enter the master password.  Here is a link to a control flow
 diagram to help visualize the logic: 
 https://drive.google.com/file/d/1Xqc-kgFA8S3Zo1TPz826N5InO0JAGLk3/view?usp=sharing
 
Based on which phrase is entered, you should call one of the methods in your password manager using the entered parameters.
For each command, the user should be able to input the command name, and the needed parameters in the correct order. 
Here are the guidelines for using commands with parameters. "Get accounts" and "Exit" do not have any parameters.

**New password:**\
input:\
New password\
Website Name\
Password

output:\
New password added

**Get password**\
input:\
Get password\
Website name

output:\
Password does not exist || the account's password

**Delete account**\
input:\
Delete Account\
Website name

output:\
Account deleted || Account does not exist

**Check duplicate password**\
input:\
Check duplicate password\
password

output: \
No account uses that password ||\
Websites using that password:\
website1\
website2

**Get accounts**\
input:\
Get accounts

output:\
Your accounts:\
account1\
account2\
account 3 etc.

**Generate random password**\
input:\
Generate random password\
Length of password (should be an int)

output:\
generated password


Below is an example of the expected inputs and outputs, where the master password is password123. 
The bold represents what is printed and the normal text is what the user enters.

**Enter Master Password**\
password\
**Enter Master Password**\
password123\
New password\
facebook\
mypassword\
**New password added**\
New passsword\
instagram\
mypassword\
**New password added**\
fake command\
**Command not found**\
Get password\
facebook\
**mypassword**\
Get password\
twitter\
**Account does not exist**\
Check duplicate password\
mypassword\
**Websites using that password:**\
**facebook**\
**instagram**\
Check duplicate password\
password789\
**No account uses that password**\
Generate random password\
10\
**Zq9CZ9noe4**\
New password\
facebook\
Zq9CZ9noe4\
**New password added**\
Get accounts\
**Your accounts:\
facebook\
instagram**\
Delete account\
facebook\
**Account deleted**\
Delete account\
snapchat\
**Account does not exist**\
Exit\
**Enter Master Password**



