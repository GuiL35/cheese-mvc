def alphabet_position(letter):
	'''find the position of a letter in alphabat table'''
	lower_let = "abcdefjhijklmnopqrstuvwxyz"
	upper_let = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	if letter in lower_let:
		return lower_let.index(letter)   ## I could use .find()just lazy here:)
	elif letter in upper_let:
		return upper_let.index(letter)
	else:
		return -1
def rotate_character(char,rot):
	'''rotate the letter by rot number of places to the right'''
	lower_let = "abcdefjhijklmnopqrstuvwxyz"
	upper_let = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	if char in lower_let:
		ind = (alphabet_position(char) + rot) % 26 
		return lower_let[ind]
	elif char in upper_let:
		ind = (alphabet_position(char) + rot) % 26 
		return upper_let[ind]
