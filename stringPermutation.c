#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define LEN 20

void mergeArray(char str[], int s1, int e1, int s2, int e2) {
  char *mergeStr;
  int i, j, k = 0;
  mergeStr = (char *)malloc((e1 - s1 + 1) + (e2 - s2 + 1));

  for (i = s1, j = s2; i <= e1 && j <= e2;) {
    if (str[i] < str[j]) {
      mergeStr[k] = str[i];
      i++;
      k++;
    } else {
      mergeStr[k] = str[j];
      j++;
      k++;
    }
  }

  while (i <= e1) {
    mergeStr[k] = str[i];
    i++;
    k++;
  }

  while (j <= e2) {
    mergeStr[k] = str[j];
    j++;
    k++;
  }

  mergeStr[k] = '\0';
  for (i = 0; mergeStr[i] != '\0'; i++) {
    str[s1 + i] = mergeStr[i];
  }

  free(mergeStr);
}

void mergeSort(char str[], int start, int end) {
  int mid;
  if (end == start) {
    return;
  }

  mid = (start + end)/2;
  mergeSort(str, start, mid);
  mergeSort(str, mid+1, end);
  mergeArray(str, start, mid, mid+1, end);
}

void swapChar(char str[], int i, int j) {
  char tmp;
  tmp = str[i];
  str[i] = str[j];
  str[j] = tmp;
}

void stringPermutations(char str[], int len, int cur, int firstWordFlag) {
  int i;
  if (cur == len - 1) {
    if(firstWordFlag == len - 1) {
      printf("%s", str);
      return;
    }
    printf(",%s", str);
  }

  for (i = cur; i < len; i++) {
    swapChar(str, i, cur);
    if (i == cur) {
      stringPermutations(str, len, cur+1, firstWordFlag + 1);
    } else {
      stringPermutations(str, len, cur+1, firstWordFlag);
    }
    swapChar(str, i, cur);

    while (str[i+1] == str[i] && i < len) {
      i++;
    }
  }
}

int main(int argc, char *argv[]) {
  FILE *fp;
  char str[LEN];
  int len;
  if (argc != 2) {
    printf("Unsupported number of parameters passed. Exiting\n");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%s", str);
  while (!feof(fp)) {
    len = strlen(str);
    mergeSort(str, 0, len - 1);
    stringPermutations(str, len, 0, 0);
    printf("\n");
    fscanf(fp, "%s", str);
  }

  fclose(fp);
  return 0;
}
