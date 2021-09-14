
# Minimum Binary Heap

A nearby has been struggling to efficiently manage their
emergency room and has brought you in to help. They want to be able to tend to the 
sickest people first, but their current system has been too slow in doing this and
those that are the sickest end up having longer wait times. 

## Part 1: Old System

Patient.java represents a patient coming into the ER. There are two constructors
for a patient, one that takes in only a value (the order which they came in) and a 
priority. The other only takes in a value and randomly assigns a priority. The lower the 
priority value is, the more severe their injuries are, and therefore they should be treated
sooner. For example a patient with priority 2 is sicker than one with priority 3. 

SimpleEmergencyRoom.java represents the current way that the hospital's database manages
the ER. Currently, the patients are stored in an ArrayList in the order they come in. All the 
methods are filled in for you except the dequeue method. 

TODO: 
1a) Fill in the dequeue method to find the patient with the smallest priority using 
a For-each loop. Return that patient and remove them from the list. 

1b) In Main.java under the "Part 1" comment, create a SimpleEmergencyRoom object and call fillER()
with the object you created as an argument. The fillER method adds 100,000 patients to your ER. (100,000 
patients is definitely an exaggeration for how many fit in an ER room but we need a large
number in order to get better times). Now dequeue from the list 10 times, and find the 
average amount of time it takes to do 1 dequeue, in nanoseconds (hint: use a for loop). 
Record your average time in data.txt. The data.txt file is where you will keep track of the times 
you calculate in order to prove to the hospital that your new implementation is more efficient. 
Write your average time in data.txt. 


## Part 2: Improved System
You recently learned about a really cool data structure called a Binary Heap in your 
COMP 210 course and figured it would apply great to this situation! 
Since the patients with lower priority are the ones we want to help
first, you will be creating a Minimum Binary Heap. BinaryHeap.java
is the interface that outlines all the methods you will need to implement
in MinBinHeapER.java. 

MinBinHeapER has an overloaded constructor. For now you can ignore the
second one (the one that takes in an array), we will get back to it
in part 3.


TODO: 
2a) Fill in the methods in MinBinHeapER.java according to the specifications
in BinaryHeap.java. The enqueue method is overloaded in MinBinHeaER but
the functionality behind the two is the same. The only difference is 
that in enqueue(V value, P priority) you create a Patient using 
the constructor that takes in both a value and priority, and in 
enqueue(V value) you create the Patient using only the value. 

2b) Now let us see how much faster the Heap is compared to the 
List used earlier. In Main.java under the "Part 2" comment,
you will do the same as you did in part 1 but with a MinBinHeapER 
object. Create the object then call fillER with that object as a parameter
(notice that there are 2 fillER methods, one for each type of Emergency Room).
Dequeue from the list 10 times and find the 
average amount of time it takes to do 1 dequeue, in nanoseconds.
Record down this number in data.txt. Now calculate the 
percent decrease between the 2 numbers and add it to the .txt file. 




## Part 3: Hospital Transfers
Sometimes, another hospital down the street is overflowing with patients and transfers
them to your ER. These new patients are represented by a Patient[] in the
database. You need to add functionality to your heap in order to turn 
this array of patients into a Minimum Binary Heap. 

TODO: Fill in the second constructor in MinBinHeapER.java to build
a heap when given an initial array of Prioritized objects. 

An example of how you can test this is shown in Main.java under the Part 3
comment. 




