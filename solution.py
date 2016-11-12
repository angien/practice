def answer(n, b):
	q = []
	k = len(n)
	seen = {}

	# create the array
	for i in range(0, b**k): 
		x = ''.join(sorted(n))[::-1] # descending order
		y = ''.join(sorted(n)) # ascending order
		while (len(x) < k):
			x = "0" + x
		while (len(y) < k):
			y = "0" + y
		n = subtractWithBase(x, y, b)
		q.append(n)
		if n not in seen:
		    seen[n] = i
		else:
		    return i - seen[n]

    # if we still haven't found a cycle, iterate through entire list again
	index = 0

	while q[index] not in seen:
		seen[q[index]] = index
		if (index > len(q)):
			index = 0
		else:
			index += 1
	
	# calculate for return value
	if index > seen[q[index]]:
		return index - seen[q[index]]
	else:
		return index + (len(q) - seen[q[index]])
		
	# n = 10, k = 2, b = 10 => 10^2 = 100 at most generate array of calculations
	# until we reach b**k

# x, y, are strings b is an ints, and this should return as string
def subtractWithBase(x, y, b):
    ans = [0] * len(x)
    for i in reversed(range(0, len(x))):
        intX = int(x[i]) - ans[i]
        intY = int(y[i])
        if( intX < intY ):
            ans[i-1] += 1
            ans[i] = str((b + intX) - intY)
        else:
            ans[i] = str(intX - intY)
    return "".join(ans)

print answer("210022", 3)