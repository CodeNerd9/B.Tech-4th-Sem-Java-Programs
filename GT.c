#include <stdio.h>
#define MAX_VERTICES 100 // maximum number of vertices in the graph

int adj_matrix[MAX_VERTICES][MAX_VERTICES]; // adjacency matrix

int main() {
    int num_vertices, num_edges;
    printf("Enter the number of vertices in the graph: ");
    scanf("%d", &num_vertices);
    printf("Enter the number of edges in the graph: ");
    scanf("%d", &num_edges);

    // initialize adjacency matrix to all zeroes
    for (int i = 0; i < num_vertices; i++) {
        for (int j = 0; j < num_vertices; j++) {
            adj_matrix[i][j] = 0;
        }
    }

    // read in edges and store in adjacency matrix
    int vertex1, vertex2;
    for (int i = 0; i < num_edges; i++) {
        printf("Enter an edge (vertex1 vertex2): ");
        scanf("%d %d", &vertex1, &vertex2);
        adj_matrix[vertex1][vertex2] = 1;
        adj_matrix[vertex2][vertex1] = 1; // assuming an undirected graph
    }

    // print out adjacency matrix
    printf("Adjacency matrix:\n");
    for (int i = 0; i < num_vertices; i++) {
        for (int j = 0; j < num_vertices; j++) {
            printf("%d ", adj_matrix[i][j]);
        }
        printf("\n");
    }

    return 0;
}
