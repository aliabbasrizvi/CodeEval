#include <stdio.h>

int main(int argc, char* argv[]) {
  FILE *fp;
  int curNum;
  int sum = 0;

  if (argc != 2) {
    printf("Unsupported number of parameters. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d", &curNum);
  while(!feof(fp)) {
    sum+=curNum;
    fscanf(fp, "%d", &curNum);
  }

  fclose(fp);
  printf("%d", sum);
  return 0;
}
