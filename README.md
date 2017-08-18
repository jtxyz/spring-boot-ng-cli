# SpringBootNgCli

This project demonstrates using Spring Boot to dynamically generate the root
page for an Angular app. The local development experience should be similar
to simply running `ng serve`, and the spring-boot-devtools should also 
function correctly.

The goals are to provide full functionality and also a good developer experience,
specifically around the following points:

- All routes without extensions are mapped to the index view, e.g. `/`, `/hello`, `/x/y/z`
- The index view is rendered by Spring MVC allowing generation of dynamic content
- No manual steps are required to include the app script bundles in the index view
- `webpack-dev-server` Automatic Refresh works
- The spring development server works
- Can run from command line or intellij
- `mvn package` builds the angular app and includes the generated content in the jar,
  allowing the app to be started with `java -jar target/*.jar`

To use the Angular live reloading functionality, run
`ng serve --deploy-url http://localhost:4200` and then start the app with the
`ng-serve` profile active.

We fetch the latest scripts from the `ng serve` webpack dev server, and specify
the `deploy-url` so the injected live reload code knows which server to connect 
back to. See the [webpack docs][1] for more info.

  [1]: https://webpack.github.io/docs/webpack-dev-server.html#combining-with-an-existing-server
