#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int isJolly(int arr[], int n) {
  char *num;
  int diff;
  int i;

  num = (char *)malloc(n-1);
  for (i = 0; i < n-1; i++) {
    num[i] = '#';
  }

  for (i = 1; i < n; i++) {
    diff = abs(arr[i] - arr[i-1]) ;

    if (diff > n - 1 || diff == 0) {
      free(num);
      return 0;
    }

    num[diff - 1] = '*';
  }

  for (i = 0; i < n-1; i++) {
    if (num[i] == '#') {
      free(num);
      return 0;
    }
  }

  free(num);
  return 1;
}

int main(int argc, char *argv[]) {
  FILE *fp;
  int *arr;
  int n, i;

  if (argc != 2) {
    printf("Unsupported number of parameters passed. Exiting.");
    return 1;
  }

  fp = fopen(argv[1], "r");
  fscanf(fp, "%d", &n);
  while (!feof(fp)) {
    arr = (int *)malloc(sizeof(int)*n);
    for (i = 0; i < n; i++) {
      fscanf(fp, "%d", &arr[i]);
    }
    if (isJolly(arr, n)) {
      printf("Jolly\n");
    } else {
      printf("Not jolly\n");
    }
    free(arr);
    fscanf(fp, "%d", &n);
  }
  return 0;
}
