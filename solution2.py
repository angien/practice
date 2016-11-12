# returns root of whatever is in q list given tree of height h
# 1 => 1
# 2 => 3
# 3 => 7
# 4 => 15
# Formula for number of elements where h is height
#   number of elements = (2^h) - 1
from collections import deque

parent = {}

def answer(h, q):
	maxNum = (2**h)-1
	
	# build tree
	tree = buildTree(h, Node(maxNum)) 
	
	ans = [-1] * len(q)
	for i in range(0, len(q)):
		if q[i] < maxNum:
			ans[i] = parent[q[i]]
			
	return ans

def buildTree(h, n):
	q = deque([[h, n]]) # height and node

	while q:
		temp = q.popleft()
		tempH = temp[0]
		tempV = temp[1].getData()
		if tempH > 1:
			tempH -= 1
			l = tempV - (2**tempH)
			r = tempV - 1
			#add to parent dictionary
			parent[l] = tempV
			parent[r] = tempV

			lNode = Node(l)
			rNode = Node(r)
			# add to tree
			n.addLeftChild(lNode)
			n.addRightChild(rNode)
			# add to queue
			q.append([tempH, rNode])
			q.append([tempH, lNode])
	return n

class Node(object):
	def __init__(self, data):
		self.data = data
		self.leftChild = None
		self.rightChild = None
		
	def addLeftChild(self, obj):
		self.leftChild = obj
		
	def addRightChild(self, obj):
		self.rightChild = obj

	def getData(self):
		return self.data


#print answer(2, [1, 2])
#print answer(4, [6, 7,8, 9, 10, 11, 12, 13, 14, 15])
#print answer(5, [6,7, 8, 9, 10, 11, 12, 13])

#print answer(20, [1900, 123424, 233337])
print answer(29, [1231232,232323,23232])

#	   15
#   7	   14   
# 3   6   10   13
#1 2 4 5 8 9 11 12