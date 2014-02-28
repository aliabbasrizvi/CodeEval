#include <stdio.h>

int main() {
  unsigned int i = 1;
  char *x = (char *)&i;

  if (*x == 1) {
    printf("LittleEndian");
  } else {
    printf("BigIndian");
  }
  return 0;
}
