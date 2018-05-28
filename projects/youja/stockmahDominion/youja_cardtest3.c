#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

//testing village card
int main (int argc, char** argv) {
    struct gameState state;     // initial state
    struct gameState state_vil;    // post village card state
    int handPos = 0;
    int numPlayers = 2;
    int z[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy};
    
    initializeGame(numPlayers, z, 15, &state);
    initializeGame(numPlayers, z, 15, &state_vil);
    state.whoseTurn = 0;
    state.hand[state.whoseTurn][handPos] = village;
    villageCard(state.whoseTurn,&state_vil, handPos);

    if (state_vil.handCount[state.whoseTurn] == state.handCount[state.whoseTurn])
        printf("Test case 1 - players card checking - PASSED \n");
    else
        printf("Test case 1 - players card checking - FAILED \n");

    if (state_vil.numActions == state.numActions + 2)
        printf("Test case 2 - Player action +2 - PASSED \n");    
    else
        printf("Test case 2 - Player action +2 - FAILED \n");   

    return 0;
}