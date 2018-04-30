#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

//test for adventurer card
int main (int argc, char** argv) {
    int hand, deck;
    int i = 0;
    int handPos = 0;
    int numPlayers = 2;
    struct gameState state;
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy};
    
    initializeGame(numPlayers, k, 15, &state);
    hand = state.handCount[state.whoseTurn];
    deck = state.deckCount[state.whoseTurn];
    state.hand[state.whoseTurn][handPos] = adventurer;
    adventurer_card(&state);
    if (state.handCount[state.whoseTurn] == hand + 2)
        printf ("Test - hand count - PASSED \n");
    else
        printf ("Test - hand count - FAILED \n");
    for (i = 0; i < 2; i++){
        if (state.hand[state.whoseTurn][state.handCount[state.whoseTurn] - 1 - i] == copper ||
            state.hand[state.whoseTurn][state.handCount[state.whoseTurn] - 1 - i] == silver ||
            state.hand[state.whoseTurn][state.handCount[state.whoseTurn] - 1 - i] == gold)
            printf ("Test - checking treasure card - PASSED \n");
        else
            printf ("Test - checking treasure card - FAILED \n");
    }
    if (state.deckCount[state.whoseTurn] <= (deck - 2))
        printf("Card deck count is decreased by 2 - PASSED \n");
    else
        printf("Card deck count is decreased by 2 - FAILED \n");
    return 0;
}