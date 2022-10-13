import queue
from time import process_time

while True:
    try:
        fibNum = int(input("Enter the position of the Fibonacci number you wish to retrieve:\n"))
        if fibNum <= 0:
            raise ValueError("Number must be greater than 0")
        break
    except ValueError:
        print("Input could not be resolved to a valid whole number. Please try again.")

fibQ = queue.Queue(2)
# seed queue with starting values
fibQ.put(1)
fibQ.put(1)

start = process_time()

count = 2
while count < fibNum:
    # sum the two values in the queue, then place the second value and the new value back into it
    first = fibQ.get()
    second = fibQ.get()
    third = first + second
    fibQ.put(second)
    fibQ.put(third)
    count += 1

# the number sought is now the second in the queue, so remove redundant first element
fibQ.get()
print("Fibonacci number #{}: {}".format(fibNum, fibQ.get()))

end = process_time()
# this may print that the operation completed in 0.0 seconds
# in that case it means that the operation took less than 0.1 seconds
print("Operation completed in {} seconds".format(end - start))
