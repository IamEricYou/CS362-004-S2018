
#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

int test_fun(int handPos, struct gameState *state);

//testing HandCard function
int main (int argc, char** argv) {
    int player, card;
    int num = 2;
    struct gameState state;
    int card_list[10] = {adventurer, embargo, minion, mine, cutpurse, gardens, village, sea_hag, tribute, smithy};
  
    initializeGame(num, card_list, 15, &state);
    state.whoseTurn = 0;
    //check the card is rightly passed
    for (player = 0; player < num; player++) {
        for (card = 0; card < state.handCount[player]; card++) {
            //call test card
            test_fun(card, &state);
        }
        endTurn(&state);
    }
    return 0;
}

int test_fun(int handPos, struct gameState *state) {
    int curr_card = state->hand[state->whoseTurn][handPos];
	int player_card = 0;
	player_card = handCard(handPos, state);
    //if card is rightly passed
	if (!player_card) {
		printf("Testing failed\n");
	} else {
		printf("Testing passed\n");
	}
    //if card is wrongly passed
	if (curr_card != player_card) {
		printf("Testing failed\n");
	} else {
		printf("Testing passed\n");
	}
	return 0;
}