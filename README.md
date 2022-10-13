# Fibonacci
A simple Fibonacci calculator

I once got asked a question about creating a Fibonacci calculator in an interview. I don't think I gave 
a very good answer, but it stuck with me enough that I decided to try my hand at it. The question was 
specifically about making the calculator as efficient as possible, so I tried to keep that in mind.

I decided to write this in Python, which has a particular limitation here, in that there is no peek
operation for queues. This means that the operation requires removing both elements of the queue, then 
redundantly adding one back in. This could be solved by a switch to a language that has a peek operator, 
or by extending the inbuilt python queue.

I'm not sure what the Big O value for the queue operations is, but given that the queue is at most two 
elements big, it shouldn't be sprialling out of control. In my tests, this code found the 50,000th 
number in the sequence in just under a second, and the 100,000th number in just over 2.5 seconds, so I 
think it's pretty good.

Also: wow, these numbers get real big real fast.
