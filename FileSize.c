#include <stdio.h>

int main(int argc, char *argv[]) {
  FILE *fp;
  int fileSize = 0;
  char ch;

  if (argc != 2) {
    printf("Unsupported number of parameters. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");

  ch = fgetc(fp);
  if (ch != EOF) {
    while(ch != EOF) {
      fileSize++;
      ch = fgetc(fp);
    }
  } 

  printf("%d", fileSize);

  fclose(fp);
  return 0;
}
