#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"


//testing smithy card
int main (int argc, char** argv) {
    int count, otherPlayerHandCount;
    int numPlayers = 2;
    int handPos = 0;
    struct gameState state;
    
    int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy};
    
    initializeGame(numPlayers, k, 15, &state);
    count = state.handCount[state.whoseTurn];
    otherPlayerHandCount = state.handCount[1];
    state.whoseTurn = 0;
    state.hand[state.whoseTurn][handPos] = smithy;
    smithyCard(state.whoseTurn,&state,handPos);
    
    if (state.handCount[state.whoseTurn] < (count + 2) || state.handCount[state.whoseTurn] > (count + 2))
        printf ("Test case 1 - FAILED \n");
    else
        printf ("Test case 1 - PASSED \n");

    if(state.handCount[1] == otherPlayerHandCount)
        printf ("Test case 2 - PASSED \n");
    else
        printf ("Test case 2 - FAILED \n");

    if(state.hand[state.whoseTurn][handPos] > -1)
        printf ("Test case 3 - PASSED \n");
    else
        printf ("Test case 3 - FAILED \n");
    return 0;
}