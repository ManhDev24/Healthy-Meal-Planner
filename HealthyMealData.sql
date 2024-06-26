USE [master]
GO
/****** Object:  Database [HealthyMeal]    Script Date: 6/24/2024 5:10:51 PM ******/
CREATE DATABASE [HealthyMeal]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HealthyMeal', FILENAME = N'D:\SQL\MSSQL16.MANH\MSSQL\DATA\HealthyMeal.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HealthyMeal_log', FILENAME = N'D:\SQL\MSSQL16.MANH\MSSQL\DATA\HealthyMeal_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [HealthyMeal] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HealthyMeal].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HealthyMeal] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HealthyMeal] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HealthyMeal] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HealthyMeal] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HealthyMeal] SET ARITHABORT OFF 
GO
ALTER DATABASE [HealthyMeal] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [HealthyMeal] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HealthyMeal] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HealthyMeal] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HealthyMeal] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HealthyMeal] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HealthyMeal] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HealthyMeal] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HealthyMeal] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HealthyMeal] SET  ENABLE_BROKER 
GO
ALTER DATABASE [HealthyMeal] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HealthyMeal] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HealthyMeal] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HealthyMeal] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HealthyMeal] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HealthyMeal] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HealthyMeal] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HealthyMeal] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HealthyMeal] SET  MULTI_USER 
GO
ALTER DATABASE [HealthyMeal] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HealthyMeal] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HealthyMeal] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HealthyMeal] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HealthyMeal] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HealthyMeal] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [HealthyMeal] SET QUERY_STORE = ON
GO
ALTER DATABASE [HealthyMeal] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [HealthyMeal]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [nvarchar](255) NOT NULL,
	[password] [nvarchar](max) NOT NULL,
	[full_name] [nvarchar](255) NOT NULL,
	[phone] [nvarchar](20) NULL,
	[address] [nvarchar](255) NULL,
	[city_id] [int] NULL,
	[district_id] [int] NULL,
	[country_id] [int] NULL,
	[role] [bit] NOT NULL,
	[status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[Id] [int] NOT NULL,
	[name] [nchar](10) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[City]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[City](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[country_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Country]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer_Plan]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer_Plan](
	[id] [int] NOT NULL,
	[account_id] [int] NULL,
	[period] [tinyint] NULL,
	[day_of_week] [tinyint] NULL,
	[dish_id] [int] NULL,
	[ordinal_number] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dish_Recipe]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dish_Recipe](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dish_id] [int] NOT NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dishes]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dishes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[price] [float] NULL,
	[status] [bit] NULL,
	[description] [nvarchar](max) NULL,
	[imageurl] [nvarchar](255) NULL,
	[date] [date] NULL,
	[categoryId] [int] NULL,
 CONSTRAINT [PK__Dishes__3213E83F007E5725] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ingredients]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ingredients](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NOT NULL,
	[unit] [nvarchar](50) NULL,
	[price] [money] NULL,
	[total_quantity] [int] NULL,
	[category] [nvarchar](100) NULL,
	[description] [text] NULL,
	[status] [bit] NULL,
	[imageurl] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](255) NULL,
	[create_account] [int] NULL,
	[period] [int] NULL,
	[day_of_week] [int] NULL,
	[dish_id] [int] NULL,
	[description] [text] NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order_Details]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Details](
	[order_id] [int] NOT NULL,
	[dish_id] [int] NOT NULL,
	[item_type] [bit] NOT NULL,
	[quantity] [int] NULL,
	[price_per_unit] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC,
	[dish_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account_id] [int] NULL,
	[order_date] [datetime] NULL,
	[ship_date] [datetime] NULL,
	[ship_address] [nvarchar](255) NULL,
	[ship_city_id] [int] NULL,
	[ship_district_id] [int] NULL,
	[total_price] [money] NULL,
	[customer_notes] [text] NULL,
	[status] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe_Ingredients]    Script Date: 6/24/2024 5:10:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe_Ingredients](
	[recipe_id] [int] NOT NULL,
	[ingredient_id] [int] NOT NULL,
	[ingredient_quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[recipe_id] ASC,
	[ingredient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([id], [email], [password], [full_name], [phone], [address], [city_id], [district_id], [country_id], [role], [status]) VALUES (1, N'john_doe', N'password123', N'John Doe', N'123-456-7890', N'123 Main St', 1, NULL, 1, 1, 1)
INSERT [dbo].[Accounts] ([id], [email], [password], [full_name], [phone], [address], [city_id], [district_id], [country_id], [role], [status]) VALUES (2, N'jane_smith', N'password123', N'Jane Smith', N'098-765-4321', N'456 Elm St', 3, NULL, 2, 1, 1)
INSERT [dbo].[Accounts] ([id], [email], [password], [full_name], [phone], [address], [city_id], [district_id], [country_id], [role], [status]) VALUES (3, N'admin', N'adminpass', N'Admin User', N'111-222-3333', N'789 Oak St', 5, NULL, 3, 0, 1)
SET IDENTITY_INSERT [dbo].[Accounts] OFF
GO
INSERT [dbo].[Category] ([Id], [name]) VALUES (1, N'Breakfast ')
INSERT [dbo].[Category] ([Id], [name]) VALUES (2, N'Lunch     ')
INSERT [dbo].[Category] ([Id], [name]) VALUES (3, N'Dinner    ')
INSERT [dbo].[Category] ([Id], [name]) VALUES (4, N'Snack     ')
INSERT [dbo].[Category] ([Id], [name]) VALUES (5, N'Dessert   ')
INSERT [dbo].[Category] ([Id], [name]) VALUES (6, N'Beverage  ')
GO
SET IDENTITY_INSERT [dbo].[Dishes] ON 

INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (1, N'Chicken Salad', 15, 1, N'Fresh chicken salad with tomatoes and lettuce', N'https://www.herwholesomekitchen.com/wp-content/uploads/2021/03/chickensalad.jpg', CAST(N'2024-01-03' AS Date), 1)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (2, N'Tomato Soup', 7.5, 1, N'Hot tomato soup', N'https://www.tasteofhome.com/wp-content/uploads/2018/07/The-Best-Ever-Tomato-Soup_EXPS_THSO18_222724_D03_06_5b-6.jpg', CAST(N'2013-03-02' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (3, N'Vegan Quinoa Salad', 8.5, 1, N'Vegan Quinoa Salad', N'https://www.healthygffamily.com/wp-content/uploads/2018/03/IMG_3666-720x720.jpg', CAST(N'2018-06-01' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (4, N'Chickpea Stew', 7.6, 1, N'Chickpea Stew', N'https://cdn77-s3.lazycatkitchen.com/wp-content/uploads/2021/04/greek-inspired-chickpea-stew-bowl-800x1200.jpg', CAST(N'2022-12-11' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (5, N'Tofu Stir Fry', 9.8, 1, N'Tofu Stir Fry', N'https://www.wellplated.com/wp-content/uploads/2019/03/How-to-Make-Tofu-Stir-Fry.jpg', CAST(N'2023-12-03' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (6, N'Avocado Toast', 6.5, 1, N'Avocado Toast', N'https://www.billyparisi.com/wp-content/uploads/2023/02/avocado-toast2.jpg', CAST(N'2010-01-23' AS Date), 1)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (7, N'Spinach Smoothie', 6, 1, N'Spinach Smoothie', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-22' AS Date), 6)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (8, N'Lentil Soup', 7, 1, N'Hearty soup made with lentils, tomatoes, and vegetables', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-21' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (9, N'Coconut Curry', 9.2, 1, N'Creamy coconut curry with tofu and vegetables', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-20' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (10, N'Mushroom Risotto', 8.5, 1, N'Creamy risotto with mushrooms and fresh herbs', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-19' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (11, N'Oatmeal', 6, 1, N'Warm oatmeal topped with fresh fruit', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-18' AS Date), 1)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (12, N'Chia Pudding', 4.8, 1, N'Delicious chia seed pudding with coconut milk', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-17' AS Date), 5)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (13, N'Broccoli Salad', 7.4, 1, N'Fresh broccoli salad with lemon vinaigrette', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-16' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (14, N'Bean Burrito', 8.2, 1, N'Spicy bean burrito with guacamole and salsa', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-15' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (15, N'Soy Stir Fry', 9, 1, N'Stir-fried tofu with soy sauce and vegetables', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-15' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (16, N'Sweet Potato Bowl', 7.5, 1, N'Nourishing bowl with roasted sweet potatoes and quinoa', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-14' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (17, N'Hummus Plate', 6.4, 1, N'Fresh hummus served with pita bread and vegetables', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-13' AS Date), 4)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (18, N'Quinoa Salad', 8.5, 1, N'Healthy salad with quinoa, cucumber, and lime dressing', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-12' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (19, N'Cauliflower Soup', 7, 1, N'Creamy soup made with cauliflower and garlic', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-11' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (20, N'Pumpkin Seed Salad', 7.6, 1, N'Salad with mixed greens, roasted pumpkin seeds, and red onion', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-10' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (21, N'Avocado Smoothie', 6, 1, N'Refreshing smoothie with avocado, spinach, and almond milk', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-09' AS Date), 6)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (22, N'Lentil Curry', 8.3, 1, N'Spicy lentil curry with brown rice', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-08' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (23, N'Chia Seed Parfait', 4, 1, N'Healthy parfait with chia seeds, oats, and fresh berries', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-07' AS Date), 5)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (24, N'Zucchini Noodles', 7.6, 1, N'Zucchini noodles with marinara sauce', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-06' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (25, N'Garlic Roasted Vegetables', 6.7, 1, N'Assorted vegetables roasted with garlic and herbs', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-05' AS Date), 3)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (26, N'Walnut Salad', 9, 1, N'Salad with mixed greens, walnuts, and balsamic vinaigrette', N'https://cdn.foodaciously.com/static/recipes/5c9ce0c1-9a11-4bbe-8ab0-49d150c22939/spinach-and-apple-breakfast-smoothie-recipe-1d39cce441ffe279e7cb0d65ce02ccff-960.webp', CAST(N'2022-01-04' AS Date), 2)
INSERT [dbo].[Dishes] ([id], [name], [price], [status], [description], [imageurl], [date], [categoryId]) VALUES (27, NULL, NULL, NULL, NULL, NULL, CAST(N'2022-01-03' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[Dishes] OFF
GO
SET IDENTITY_INSERT [dbo].[Ingredients] ON 

INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (1, N'Tomato', N'kg', 2.5000, 100, N'Vegetable', N'Fresh tomatoes', 1, N'tomato.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (2, N'Chicken Breast', N'kg', 10.0000, 50, N'Meat', N'Boneless chicken breast', 1, N'chicken.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (3, N'Salt', N'g', 0.0100, 1000, N'Spice', N'Table salt', 1, N'salt.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (4, N'Tomato', N'kg', 2.5000, 100, N'Vegetable', N'Fresh tomatoes', 1, N'tomato.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (5, N'Broccoli', N'kg', 3.0000, 80, N'Vegetable', N'Fresh broccoli', 1, N'broccoli.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (6, N'Tofu', N'kg', 5.0000, 60, N'Protein', N'Organic tofu', 1, N'tofu.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (7, N'Salt', N'g', 0.0100, 1000, N'Spice', N'Table salt', 1, N'salt.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (8, N'Garlic', N'g', 0.0500, 500, N'Spice', N'Fresh garlic', 1, N'garlic.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (9, N'Olive Oil', N'L', 10.0000, 40, N'Oil', N'Extra virgin olive oil', 1, N'olive_oil.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (10, N'Spinach', N'kg', 3.0000, 200, N'Vegetable', N'Fresh spinach leaves', 1, N'https://example.com/images/spinach.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (11, N'Chickpeas', N'kg', 2.5000, 150, N'Protein', N'Canned chickpeas', 1, N'https://example.com/images/chickpeas.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (12, N'Quinoa', N'kg', 4.0000, 120, N'Grain', N'Organic quinoa', 1, N'https://example.com/images/quinoa.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (13, N'Bell Peppers', N'kg', 3.5000, 160, N'Vegetable', N'Assorted bell peppers', 1, N'https://example.com/images/bell_peppers.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (14, N'Almond Milk', N'L', 3.0000, 80, N'Dairy Alternative', N'Unsweetened almond milk', 1, N'https://example.com/images/almond_milk.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (15, N'Avocado', N'kg', 6.0000, 100, N'Fruit', N'Fresh avocado', 1, N'https://example.com/images/avocado.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (16, N'Lentils', N'kg', 3.5000, 150, N'Protein', N'Dried lentils', 1, N'https://example.com/images/lentils.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (17, N'Brown Rice', N'kg', 2.0000, 200, N'Grain', N'Organic brown rice', 1, N'https://example.com/images/brown_rice.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (18, N'Coconut Milk', N'L', 4.0000, 100, N'Dairy Alternative', N'Unsweetened coconut milk', 1, N'https://example.com/images/coconut_milk.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (19, N'Mushrooms', N'kg', 3.5000, 120, N'Vegetable', N'Assorted mushrooms', 1, N'https://example.com/images/mushrooms.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (20, N'Oats', N'kg', 2.5000, 180, N'Grain', N'Rolled oats', 1, N'https://example.com/images/oats.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (21, N'Chia Seeds', N'kg', 7.0000, 80, N'Seed', N'Organic chia seeds', 1, N'https://example.com/images/chia_seeds.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (22, N'Broccoli', N'kg', 3.0000, 150, N'Vegetable', N'Fresh broccoli', 1, N'https://example.com/images/broccoli.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (23, N'Kidney Beans', N'kg', 3.5000, 150, N'Protein', N'Canned kidney beans', 1, N'https://example.com/images/kidney_beans.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (24, N'Soy Sauce', N'L', 5.0000, 120, N'Condiment', N'Organic soy sauce', 1, N'https://example.com/images/soy_sauce.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (25, N'Sweet Potatoes', N'kg', 3.0000, 120, N'Vegetable', N'Fresh sweet potatoes', 1, N'https://example.com/images/sweet_potatoes.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (26, N'Hummus', N'kg', 6.0000, 100, N'Dip', N'Chickpea-based hummus', 1, N'https://example.com/images/hummus.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (27, N'Lemon', N'kg', 2.0000, 200, N'Fruit', N'Fresh lemon', 1, N'https://example.com/images/lemon.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (28, N'Cucumber', N'kg', 1.5000, 180, N'Vegetable', N'Fresh cucumber', 1, N'https://example.com/images/cucumber.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (29, N'Cauliflower', N'kg', 3.5000, 150, N'Vegetable', N'Fresh cauliflower', 1, N'https://example.com/images/cauliflower.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (30, N'Pumpkin Seeds', N'kg', 8.0000, 80, N'Seed', N'Roasted pumpkin seeds', 1, N'https://example.com/images/pumpkin_seeds.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (31, N'Lime', N'kg', 2.5000, 200, N'Fruit', N'Fresh lime', 1, N'https://example.com/images/lime.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (32, N'Red Onion', N'kg', 2.5000, 180, N'Vegetable', N'Fresh red onion', 1, N'https://example.com/images/red_onion.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (33, N'Walnuts', N'kg', 10.0000, 100, N'Nut', N'Raw walnuts', 1, N'https://example.com/images/walnuts.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (34, N'Zucchini', N'kg', 2.5000, 150, N'Vegetable', N'Fresh zucchini', 1, N'https://example.com/images/zucchini.jpg')
INSERT [dbo].[Ingredients] ([id], [name], [unit], [price], [total_quantity], [category], [description], [status], [imageurl]) VALUES (35, N'Garlic', N'kg', 1.5000, 200, N'Vegetable', N'Fresh garlic cloves', 1, N'https://example.com/images/garlic.jpg')
SET IDENTITY_INSERT [dbo].[Ingredients] OFF
GO
ALTER TABLE [dbo].[Accounts] ADD  DEFAULT ((1)) FOR [role]
GO
ALTER TABLE [dbo].[Accounts] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Menu] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Order_Details] ADD  DEFAULT ((1)) FOR [item_type]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[City]  WITH CHECK ADD FOREIGN KEY([country_id])
REFERENCES [dbo].[Country] ([id])
GO
ALTER TABLE [dbo].[Customer_Plan]  WITH CHECK ADD FOREIGN KEY([account_id])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[Customer_Plan]  WITH CHECK ADD  CONSTRAINT [FK__Customer___dish___6EF57B66] FOREIGN KEY([dish_id])
REFERENCES [dbo].[Dishes] ([id])
GO
ALTER TABLE [dbo].[Customer_Plan] CHECK CONSTRAINT [FK__Customer___dish___6EF57B66]
GO
ALTER TABLE [dbo].[Dish_Recipe]  WITH CHECK ADD  CONSTRAINT [FK__Dish_Reci__dish___4D94879B] FOREIGN KEY([dish_id])
REFERENCES [dbo].[Dishes] ([id])
GO
ALTER TABLE [dbo].[Dish_Recipe] CHECK CONSTRAINT [FK__Dish_Reci__dish___4D94879B]
GO
ALTER TABLE [dbo].[Dishes]  WITH CHECK ADD  CONSTRAINT [FK_Dishes_Category] FOREIGN KEY([categoryId])
REFERENCES [dbo].[Category] ([Id])
GO
ALTER TABLE [dbo].[Dishes] CHECK CONSTRAINT [FK_Dishes_Category]
GO
ALTER TABLE [dbo].[Menu]  WITH CHECK ADD  CONSTRAINT [FK__Menu__dish_id__693CA210] FOREIGN KEY([dish_id])
REFERENCES [dbo].[Dishes] ([id])
GO
ALTER TABLE [dbo].[Menu] CHECK CONSTRAINT [FK__Menu__dish_id__693CA210]
GO
ALTER TABLE [dbo].[Menu]  WITH CHECK ADD FOREIGN KEY([create_account])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[Order_Details]  WITH CHECK ADD  CONSTRAINT [FK__Order_Det__dish___628FA481] FOREIGN KEY([dish_id])
REFERENCES [dbo].[Dishes] ([id])
GO
ALTER TABLE [dbo].[Order_Details] CHECK CONSTRAINT [FK__Order_Det__dish___628FA481]
GO
ALTER TABLE [dbo].[Order_Details]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[Orders] ([id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([account_id])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[Recipe_Ingredients]  WITH CHECK ADD FOREIGN KEY([ingredient_id])
REFERENCES [dbo].[Ingredients] ([id])
GO
ALTER TABLE [dbo].[Recipe_Ingredients]  WITH CHECK ADD FOREIGN KEY([recipe_id])
REFERENCES [dbo].[Dish_Recipe] ([id])
GO
ALTER TABLE [dbo].[Customer_Plan]  WITH CHECK ADD CHECK  (([day_of_week]=(7) OR [day_of_week]=(6) OR [day_of_week]=(5) OR [day_of_week]=(4) OR [day_of_week]=(3) OR [day_of_week]=(2)))
GO
ALTER TABLE [dbo].[Customer_Plan]  WITH CHECK ADD CHECK  (([period]=(3) OR [period]=(2) OR [period]=(1)))
GO
ALTER TABLE [dbo].[Menu]  WITH CHECK ADD CHECK  (([day_of_week]=(7) OR [day_of_week]=(6) OR [day_of_week]=(5) OR [day_of_week]=(4) OR [day_of_week]=(3) OR [day_of_week]=(2)))
GO
ALTER TABLE [dbo].[Menu]  WITH CHECK ADD CHECK  (([period]=(3) OR [period]=(2) OR [period]=(1)))
GO
USE [master]
GO
ALTER DATABASE [HealthyMeal] SET  READ_WRITE 
GO
