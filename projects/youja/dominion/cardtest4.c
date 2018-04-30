#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

//testing for the council room
int main (int argc, char** argv) {

    struct gameState state;    
    struct gameState state_clr;  
    int handPos = 0;
    int numPlayers = 2;
    int z[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy};
 
    initializeGame(numPlayers, z, 15, &state);
    initializeGame(numPlayers, z, 15, &state_clr);
    state.whoseTurn = 0;
    state.hand[state.whoseTurn][handPos] = council_room;
    council_room_card(&state_clr,handPos);
    
    if (state_clr.handCount[state.whoseTurn] == state.handCount[state.whoseTurn] + 3)
        printf("Test1 - check the player card + 3 - PASSED \n ");
    else
        printf("Test1 - check the player card + 3 - FAILED \n ");

    if (state_clr.numBuys == state.numBuys + 1)
        printf("Test case 2 - player buy + 1 -- PASSED \n ");     
    else
        printf("Test case 2 - player buy + 1 -- FAILED \n ");

    if (state_clr.hand[state.whoseTurn][handPos] > -1)
        printf ("Test case 3 - discard the card - PASSED \n");
    else
        printf ("Test case 3 - discard the card - FAILED \n");
    
    if (state_clr.deckCount[state.whoseTurn] == (state.deckCount[state.whoseTurn] - 4))
            printf ("Test case 4 - reduced deck by 4 -- PASSED \n ");
    else
            printf ("Test case 4 - reduced deck by 4 -- FAILED \n ");
    return 0;
}