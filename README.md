# Install and run
All you need is to move into the directory and run
```bash
./mvnw.cmd spring-boot:run
```
for Windows and
```bash
./mvnw spring-boot:run
```
for Linux and (probably) OS X.
Then in your browser open up `localhost:8080/` and start using the app.
# Usage
The machine has the following commands:
```
% 'percent' means a comment
V x % marks the node and moves to the command num. x
X x % erases the node and moves to the command num. x
> x % moves right and moves to the command num. x
< x % moves left and moves to the command num. x
? x y % if the current node is emty, go to x, else to y
! % stops execution
```
Command numerations start from 0.

As an example, you can use the following program:
```
> 1
? 0 2
< 3
V 4
!
```
It marks the node left to the first marked one. If you input a tape full of zeroes, it will throw a timeout error.

The following code will try to mark an already marked field:
```
> 1
? 0 2
V 4
!
```
If you execute it, it will throw an error.