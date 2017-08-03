from helpers import alphabet_position, rotate_character

def encrypt(text,rot):
        '''Vigenere cipher, this program will behave like this:
        $ python vigenere.py
        Type a message:
        The crow flies at midnight!
        Encryption key:
        boom
        Uvs osck rmwse bh auebwsih! '''
        new_str = ""
        ind_key = 0
        for symbol in text:
            if (alphabet_position(symbol) != -1):   # make sure the symbol is a characte
                new_let = rotate_character(symbol, alphabet_position(rot[ind_key]))
                new_str += new_let
                ind_key += 1
                if ind_key >= len(rot):
                    ind_key = 0
            else:
                new_str += symbol
        return new_str

def main():
        text = input("type the message: ")
        rot = input("Encryption key: ")
        print(encrypt(text,rot))

if __name__ == '__main__':
        main()
