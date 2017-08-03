from helpers import alphabet_position, rotate_character       
def encrypt(text,rot):
        new_str = ""
        for letter in text:
            new_str += rotate_character(letter,rot)
        return new_str
            
def main():
        text = input("type a message: ")
        rot = int(input("Rotate by: "))
        print(encrypt(text,rot))

if __name__ == '__main__':
        main()
