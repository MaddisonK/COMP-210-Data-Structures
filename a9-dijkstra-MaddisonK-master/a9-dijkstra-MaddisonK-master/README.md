# Dijkstra's Algorithm

After being stuck at home due to the pandemic all summer, you have decided to take a cross country road trip,
starting from Chapel-Hill and ending Los Angeles.
Along the way you would like to make some stops and to visit some new places!
It is up to you, using Dijkstra's Algorithm, to figure out the most optimal way from CH to LA.

However, optimal does not necessarily mean the shortest.
We have provided you a list of the paths between every city and its corresponding distance, scenery, and traffic. We also gave some attractions in each city that may (or may not) interest you. 
This assignment has 2 parts: Creating your weights, and implementing Dijkstra's algorithm

## Creating Weights
   The excel sheet titled roadtrip is what you need to fill in with numbers that you wanna assign each factor. 
   
   link: https://docs.google.com/spreadsheets/d/1mB565mYrsWRLblfatBxrCXQe-3W9pQlL9fs46IYI_pE/edit?usp=sharing
   
   
   This link is view only, in order to edit it, go to file -> make a copy and that will create an editable copy of the file in your Google Drive. 
   The distance column is pre-filled in for you, but based on the details at the bottom of the instructions you should assign scores for each of the other categories (for example, you can assign heavy traffic a 5 and medium traffic a 3). These numbers are completely up to you; if scenery is not something you value 
   in a roadtrip, the entire scenery column can be 0s. Since roads go both ways, this graph is an undirected graph. 
   Each row in the excel sheet represents a road going one way. The starter code given takes care of making the edges go
   both directions, so all you need to do is fill in the numbers for each category.
    Once you filled in all of those, save and download your excel sheet as a .csv file (File -> Download -> Comma seperate values) and take a look at Graph.java. The createGraph method reads each line from your csv file and passes in the source and destination cities, and the distance, traffic, scenery, and attractions scores that you assigned to readLine(). ReadLine() then calls calculateWeight() and passes in those same arguments. 
    
    *IMPORTANT* In order to create a graph (in Main.java), you must pass in to the contstructor the
    path for where your csv file is stored. If you pass in the incorrect path you will get a 
    FileNotFoundException.
    
    How to find your file path:
    Mac: Locate the file in your finder and right click on it. Hold down the option key and select 
            'Copy "roadtrip.csv" as Pathname'. The absolute path of your file is now copied to your clipboard.
    Windows: Locate the file in your file explorer, shift + right click on file, then select "Copy as path"
    
   The calculateWeight method is where you create your algorithm using 4 factors to produce a single weight for your edge. However, make sure you are not doing any illegal math operations. For example if you divide a number by traffic, make sure you never pass in 0 for traffic since you cannot divide by 0. You can also choose to emphasize certain factors over others. For instance if your car gets really bad gas mileage, you could give distance more weight
as opposed to scenery. Also be sure that your weights are **positive**. Dijkstra's algorithm does NOT work with negative values.

    
   Once you have completed this part, Write 1 paragraph explaining your reasoning behind your scores for each category,
    and how your algorithm works. Write this paragraph in the Explanation.txt file provided. 
    
    
## Implementing Dijkstra's Algorithm    

   Part 2 of this project is to implement Dijkstra's algorithm, using a priorty queue. The package minBinHeap contains the code for a Minimum Binary Heap that you will be using for your algorith (do not edit anything in that folder).
   The Dijkstra method in Graph.java should return a Map with they key being the name of the city, and the value
    being the total weight that it takes to reach that city from your starting point. 
    Once you are confident your algorithm works, add to your Explanation.txt file an 
    overview of your roadtrip. Give us 1 paragraph explaining what cities you are going to hit 
    between Chapel Hill and LA, the weight of each path you take and what attractions you're planning to visit 
    on the way (this doesn't necessarily have to be the ones list below). 



### Attractions
Chicago
- The Bean
- Wrigley Field 
- Deep Dish Pizza!

Nashville
- Country Music Capital
- Grand Ole Opry
- Centennial PArk

Dallas
- Six Flags
- Dallas Arboretum and Botanical Garden
- Sixth Floor Museum at Dealey Plaza (museum about the JFK assassination)

Las Vegas
- Las Vegas Strip
- Red Rock Canyon
- Bellagio Hotel and Casino

Phoenix
- Desert Botanical Garden
- Camelback Mountain
- Papago Park

Denver
- Red Rocks Park and Amphitheatre
- Great Skiing Resorts
- Denver Art Museum

San Francisco
- Golden Gate Bridge
- Alcatraz Island
- Fisherman's Wharf

Los Angeles
- Potential Celebrity Citings
- DisneyLand
- Santa Monica Pier


### Road Information
**CH - Nashville:**\
Scenery: Nice, you drive through the Pisgah National Forest\
    Traffic: No traffic

**CH - Chicago**\
    Scenery: Mostly highway but a nice drive through the West Virginia mountains\
    Traffic: Low
    
**CH - Dallas**\
    Scenery: Pretty drive through hills and forests\
    Traffic: Heavy
     
**Vegas - San Francisco**\
    Scenery: Goes through Death Valley National Park\
    Traffic: Average traffic

**Dallas - Phoenix**\
    Scenery: Mostly farms and fields\
    Traffic: Heavy traffic

**Dallas - Denver**\
    Scenery: Desert scenery, mainly flat\
    Traffic: Moderate traffic
    
**Denver - Chicago**\
    Scenery: Midwestern Scenery\
    Traffic: Low

**Denver - Nashville**\
    Scenery: Most of drive is through forests and open fields
    Traffic: No traffic

**Chicago - Vegas**\
    Scenery: Pass through 4 states with changing scenery, from fields to desert\
    Traffic: Medium traffic

**Chicago - San Francisco**\
    Scenery: Some national forests on the way\
    Traffic: None

**Vegas - Phoenix**\
    Scenery: Desert scenery\ 
    Traffic: High

**Phoenix - LA**\
    Scenery: Desert scenery\
    Traffic: Low traffic

**Phoenix - Denver**\
    Scenery: Many national forests\
    Traffic: Moderate

**LA - San Francisco**\
    Scenery: Incredible ocean views on Pacific Coast Highway\
    Traffic: Light
    


