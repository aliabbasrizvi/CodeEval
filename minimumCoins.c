#include <stdio.h>

int minCoins(int val) {
  if (val <= 0) {
    return 0;
  }

  if (val == 1 || val == 5 || val == 3) {
    return 1;
  }

  if (val > 5) {
    return (1 + minCoins(val - 5));
  } else if (val > 3) {
    return (1 + minCoins(val - 3));
  } else if (val > 1) {
    return (1 + minCoins(val - 1));
  }
}

int main (int argc, char *argv[]) {
  int num;
  FILE *fp;

  if (argc != 2) {
    printf("Insufficient number of parameters passed\n");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d", &num);
  while(!feof(fp)) {
    printf("%d\n", minCoins(num));
    fscanf(fp, "%d", &num);
  }

  fclose(fp);
  return 0;
}
