using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace backend
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Configuração e serviços de API Web
            config.Formatters.Remove(config.Formatters.XmlFormatter);
            // Rotas de API Web
            config.MapHttpAttributeRoutes();

            config.Routes.MapHttpRoute(
                name: "Rota de Login",
                routeTemplate: "api/login/{login}/{senha}",
                new
                {
                    Controller = "User",
                    login = string.Empty,
                    senha = string.Empty
                }
            );
        }
    }
}
