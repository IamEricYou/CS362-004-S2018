//adventurer Card test
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <assert.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"

int testpass = 0;
int testfail = 0;

void test_adv(int count);

int main(){
    srand(time(NULL));
    int i = 0;
    int count = 0;
    printf("Testing adventurer Card \n");
    for(i = 0; i < 5000; i++){
        test_adv(count);
        count++;
    }

    printf("Total random test: %d, PASSED test: %d, FAILED test: %d \n", 5000,testpass,testfail);
    return 0;
}

void test_adv(int count){
    struct gameState *state = newGame();
    struct gameState *testState = newGame();
    int k[10] = {adventurer, council_room, remodel, smithy, village, salvager, gardens, mine, ambassador, great_hall};
    int random_player = 2; //rand() % 4 + 2; //it should be fixed value to check only random value affacts to the fucntion of smithy card
    //int random_card = rand() % 6; //random card will be passed btw 0-5
    int random_tresure = rand()%7;
    int seed = 1000;
    int yourturn = 0;
    int check_card_result = 0;
    int i = 0;

    initializeGame(random_player,k,seed,state);
    //state->whoseTurn = random_player;

    memcpy(testState,state,sizeof(struct gameState));

    testState->hand[yourturn][testState->handCount[yourturn]] = adventurer;
    testState->handCount[yourturn] = testState->handCount[yourturn] + 1;

    
    adventurer_card(testState);
    //test: gain two treasure card correclty
    for(i = 0; i < 2; i++){
        state->deck[yourturn][i] = random_tresure;
        //gold = 6, siliver = 5, copper = 4. Random number (0 - 6) will be added.
    }
    check_card_result = testState->hand[yourturn][testState->handCount[yourturn]-1];
    if(check_card_result != copper && check_card_result != silver && check_card_result != gold){
        testfail = testfail + 1;
        return;
    }

    check_card_result = testState->hand[yourturn][testState->handCount[yourturn]-2];
    if(check_card_result != copper && check_card_result != silver && check_card_result != gold){
        testfail = testfail + 1;
        return;
    }
    
    //test: reveal cards your deck

    check_card_result = testState->deckCount[yourturn];
    
    if(check_card_result > state->deckCount[yourturn]){
        //Not good, deck count has to be less.
        testfail = testfail + 1;
        return;
    }

    testpass = testpass + 1;  // +1 if nothing failed
}