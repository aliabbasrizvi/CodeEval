#include <stdio.h>

int mod(int n, int m) {
  if (n < m) {
    return n;
  }

  return mod(n - m, m);
}

int main (int argc, char *argv[]) {
  int n, m;
  FILE *fp;

  if (argc != 2) {
    printf("Insufficient number of parameters passed\n");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d,%d", &n, &m);
  while(!feof(fp)) {
    printf("%d\n", mod(n, m));
    fscanf(fp, "%d,%d", &n, &m);
  }

  fclose(fp);
  return 0;
}
