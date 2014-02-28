#include <stdio.h>
#define LEN 30

void printBinaryEquivalent(int number) {
  char binEq[LEN];
  int i=-1, j;

  if (number == 0) {
    printf("0\n");
    return;
  }

  while (number != 0) {
    if (number % 2 == 1) {
      binEq[++i] = '1';
    } else {
      binEq[++i] = '0';
    }
    number = number >> 1;
  }

  for (j = i; j >= 0; j--) {
    printf("%c", binEq[j]);
  }
  printf("\n");
}

int main(int argc, char *argv[]) {
  FILE *fp;
  int num;

  if (argc != 2) {
    printf("Unsupported number of parameters. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d", &num);
  while(!feof(fp)) {
    printBinaryEquivalent(num);
    fscanf(fp, "%d", &num);
  }

  fclose(fp);
  return 0;
}
