#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

/**
 * include every lowercase letter in the alphabet
 * + every type of brackets (because target char has the brackets)
 **/
const char *temp_char = " ()[]{}abcdefghijklmnopqrstuvwxyz";

/**
 * temp_string includes a random order of the word 'reset'
 * I set the 'reset' word long, so it will take a longer time to match the
 * 'reset' word.
 */
const char *temp_string = "rrerersesetseeeetstt";

char inputChar()
{
	//return a char in random index.
	return temp_char[rand() % 32];
}

char *inputString()
{
	static char reset_str[5];
	int i = 0;
	for (i = 0; i < 5; i++)
	{
		//this array will store random word (length of 5) in temp_string
		//like "rrtts", "eerst", "ttres", or "reset" <- this is a stopping point.
		reset_str[i] = temp_string[rand() % 19];
	}
	return reset_str;
}

void testme()
{
	int tcCount = 0;
	char *s;
	char c;
	int state = 0;
	while (1)
	{
		tcCount++;
		c = inputChar();
		s = inputString();
		printf("Iteration %d: c = %c, s = %s, state = %d\n", tcCount, c, s, state);

		if (c == '[' && state == 0)
			state = 1;
		if (c == '(' && state == 1)
			state = 2;
		if (c == '{' && state == 2)
			state = 3;
		if (c == ' ' && state == 3)
			state = 4;
		if (c == 'a' && state == 4)
			state = 5;
		if (c == 'x' && state == 5)
			state = 6;
		if (c == '}' && state == 6)
			state = 7;
		if (c == ')' && state == 7)
			state = 8;
		if (c == ']' && state == 8)
			state = 9;
		if (s[0] == 'r' && s[1] == 'e' && s[2] == 's' && s[3] == 'e' && s[4] == 't' && s[5] == '\0' && state == 9)
		{
			printf("error ");
			exit(200);
		}
	}
}

int main(int argc, char *argv[])
{
	srand(time(NULL));
	testme();
	return 0;
}
