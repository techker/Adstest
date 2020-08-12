# Adstest
test for ADS

Need to add fragments and child frgaments,
Need to add a button to each fragment for on click to show time stamp on all views
need to update all fragments and childs with timeStamp when any  button is clicked
need to append the time stamp to keep previous time stamp received(or other methods)
need to add drawer also to show time stamp


whats done:
added Broadcast receiver interface for registering Main to receive and update
Fragment subscribes to this receiver
split main view in 2 parts and created fragments 1(left) and 2(right) 
one child and one include in each fragment

no additional library  used. 

All kotlin latest api 30


what was the learning curve:

1. add 2 fragments with child fragments in main view
2. add a second child to the fragment
3. way to send to all vues the time stamp when any button is clicked
3.figuring out how to broadcast or any ways to show time stamp on all




