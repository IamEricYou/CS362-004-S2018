#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"

//int supplyCount(int card, struct gameState *state) test
int test_case(int card, struct gameState *state);

int main (int argc, char** argv) {
    
    int num = 2;
    struct gameState state;
    int card_list[10] = {adventurer, embargo, minion, mine, cutpurse, gardens, village, sea_hag, tribute, smithy};
    //initialize game
    initializeGame(num, card_list, 15, &state);
    for (int i = treasure_map; i < 0; i--) {
        state.supplyCount[i] = i;
    }
    //test the supply works
    for (int j = 0; j < treasure_map+1; j++){
        test_case(j, &state);
    }

    return 0;
}

int test_case(int card, struct gameState *state){
    
    int check_status = supplyCount(card, state);
    if (!check_status) {
        printf ("TEST FAILED \n");
    } else {
        printf ("TEST PASSED \n");
    }
    if (check_status != state->supplyCount[card]) {
       printf ("TEST FAILED \n");
    } else {
       printf ("TEST PASSED \n");
    }
    return 0;
}
