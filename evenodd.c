#include <stdio.h>

int isEven(int num) {
  if (num % 2 == 0) {
    return 1;
  } else {
    return 0;
  }
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char *str;
  int num;

  if (argc != 2) {
    printf("Incorrect number of parameters passed. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d", &num);
  while (!feof(fp)) {
    printf("%d\n", isEven(num));
    fscanf(fp, "%d", &num);
  }

  fclose(fp);
  return 0;
}
