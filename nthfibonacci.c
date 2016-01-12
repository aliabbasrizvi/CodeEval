#include <stdio.h>

int nthFibonacci(int num) {
  int num1 = 0, num2 = 1;
  int nthFibo;
  int i;

  for (i = 2; i <= num; i++) {
    nthFibo = num1 + num2;
    num1 = num2;
    num2 = nthFibo;
  }
  return nthFibo;
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
    printf("%d\n", nthFibonacci(num));
    fscanf(fp, "%d", &num);
  }

  fclose(fp);
  return 0;
}
