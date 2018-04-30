#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

//test for int isGameOver(struct gameState *state)

void check_test (struct gameState *state);

int main (int argc, char** argv) {
    int num = 2;
    struct gameState state;
    int card_list[10] = {adventurer, embargo, minion, mine, cutpurse, gardens, village, sea_hag, tribute, smithy};
    
    //initialize the game first
    initializeGame(num, card_list, 15, &state);
    
    //cause the game over
    state.supplyCount[adventurer] = 0;
    state.supplyCount[gardens] = 0;
    state.supplyCount[embargo] = 0;  
    check_test(&state); // if game is over, test is done

    //cause the game over
    state.supplyCount[province] = 0;
    check_test(&state); // if game is over, test is done

    return 0;
}
void check_test (struct gameState *state) {
    if(!isGameOver(state)) {
        printf ("TEST FAILED. THE GAME is not over\n");
    } else {
        printf ("TEST PASSED. THE GAME is over successfully\n");
    }
}
