Yuki Okamoto
Project 02
CST 338


# [Android Application: Skateboard market]

This application is selling and purchasing skateboard.

Administrators can see/add/delete the information of users, and see/add/modify/delete items.
Users can buy and sell items.

Please mark each use case as 'pass' Or 'fail'. The use case passes if it does what it intended to do. It fails if it does not. See the example below for more information.



Table of contents

## Use Case 01: Predefined Users
pass

1. Login as testuser1
2. Display the username 'testuser1'
2. Logout
4. Login as admin2
5. Display the username 'admin2'
6. Display something specific to the admin user.


https://youtube.com/shorts/rBfga7cA3Lw?feature=share


## Use Case 02: SharedPreference and Logout
pass

1. Login as a user
2. Force quit application
3. Automatic login
4. Click LOGOUT
5. Login as a user 
6. Show user name
7. Logout
8. Does not show user name

https://youtube.com/shorts/xerEgKcpO6A


## Use Case 03: Add a user
pass

1. Put the button CREATE A USER 
2. Create a user with username and password
3. Show the username is correct
4. Login with the user who is created at 1
5. Show the username is correct

https://youtube.com/shorts/XQvXsd7VLOc?feature=share

## Use Case 04: Persistence
pass

1. From Use Case 03 user is added
2. Force quit the application
3. Login with the user created Use Case 03
4. Show the username is correct

https://www.youtube.com/shorts/lBpbY_Ocjk4

## Use Case 05: View existing users
pass

1. Login as an admin
2. Go to ADMIN
3. Check if the users exist that you added and predefined.

https://www.youtube.com/shorts/x8SMOnyHRec

## Use Case 06: Add a admin
pass

1. Put the button CREATE A USER
2. Switch on the admin
3. Login with the admin who is created at 1
4. Go to ADMIN 
5. Check if the USER status is admin

https://youtube.com/shorts/KzW6ekZ1wEE

## Use Case 07: Delete a user
pass

1. Login as admin
2. Go to ADMIN
3. Long click a user
4. Toast “username is deleted”
5. Check existing users
6. Force quit the application
7. Login as a deleted user
8. Show “Invalid Credentials!”


https://youtu.be/0yYoFcGe6zU

## Use Case 08: Cannot delete a user
pass

1. Login as admin
2. Go to ADMIN
3. Delete yourself (admin)
4. Toast “Cannot delete yourself”


https://youtu.be/yeLvtzW9UuI

## Use Case 09: Sell an item
pass

1. Login as a user
2. Go to SELL
3. Click the + button icon
4. Enter deck name, deck size, and price of item
5. Press ADD button
6. Toast Item Registered!!!
7. Show the new item
8. Force quit
9. Login as the same user
10. Go to SELL
11. Show the item

https://youtu.be/jbTh8RKVYek

## Use Case 10: Input Validation
pass

1. Login as a user
2. Go to SELL
3. Click the + button icon
4. Press ADD button
5. Toast Fill all fields
6. Input only size
7. Press ADD button
8. Toast Fill all fields

https://www.youtube.com/shorts/LA85cnnfinQ

## Use Case 11: View selling items from User
pass

1. Login as an user
2. Go to SELL
3. Show the items that the user added

https://youtu.be/85Zu6WXI_Ng

## Use Case 12: Delete an item
pass

1. Login as an user
2. Go to SELL
3. Long click the item that you want to delete
4. Toast item name is deleted
5. Show the item is deleted in the List
6. Force quit the application
7. Automatic login
8. Go to SELL
9. Show the item is deleted in the List

https://youtu.be/_afSLGcbt-M


## Use Case 13: Modify an item
pass

1. Login as an user
2. Go to SELL
3. Click the item that you want to edit
4. the deck name, size, and price is already filled that is same data as you clicked
5. Edit the data
6. Press the MODIFY button
7. Toast Item Modified!!!
8. Show the item is modified
9. Force quit the application
10. Automatic login
11. Go to SELL
12. Show the item is edited in the List

https://youtu.be/GQB01g4kgFM

## Use Case 14: View selling all items from Admin
pass

1. Login as an admin
2. Go to ADMIN
3. Click the ITEMS tab
4. Show all items 

https://youtube.com/shorts/LJ0WbqPClwY


## Use Case 15: Delete an item from Admin
pass

1. Login as an admin
2. Go to ADMIN
3. Click the ITEMS tab
4. Long lick the item
5. item name is deleted
6. Show the item is deleted in the List
7. Force quit the application
8. Automatic login
9. Go to ADMIN
10. Click the ITEMS tab
11. Show the item is deleted in the List

https://youtu.be/D5gYgCaFlmE

## Use Case 16: Purchase an item
pass

1. Login as a user
2. Go to BUY
3. Long click to Buy an item
4. Toast Item name is purchased!!
5. Go to ORDER HISTORY
6. Show the item that you purchased.

https://youtu.be/3q5olWRxdiM


## Use Case 17: Cancel an item
pass
1. Login as a user
2. Go to ORDER HISTORY
3. Long click to cancel an item
4. Toast The purchase of item name is canceled!!
5. Go to BUY
6. Show the item that you canceled

https://youtube.com/shorts/HPJdLhXsliA


