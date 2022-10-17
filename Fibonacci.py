from time import process_time


def askNum() -> int:
    while True:
        try:
            fibNum = int(input("Enter the position of the Fibonacci number you wish to calculate:\n"))
            if fibNum <= 0:
                raise ValueError("Number must be greater than 0")
            break
        except ValueError:
            print("Input could not be resolved to a valid whole number. Please try again.")
    return fibNum


def calculate(fibNum: int):
    fibOne, fibTwo = 1, 1

    start = process_time()

    # count starts at 2 because we already have the first two Fibonacci numbers
    count = 2
    while count < fibNum:
        temp = fibTwo
        fibTwo += fibOne
        fibOne = temp
        count += 1

    print("Fibonacci number #{}: {}".format(fibNum, fibTwo))

    end = process_time()
    # this may print that the operation completed in 0.0 seconds
    # in that case it means that the operation took less than 0.1 seconds
    print("Operation completed in {} seconds".format(end - start))


calculate(askNum())
